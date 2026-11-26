package JsonMapper;

import Data.Address;
import Data.Employee;
import Data.Movie;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Objects;

public class JsonMapper {

    public static void main(String[] args) throws IllegalAccessException {
        Movie[] favoriteMovies = {new Movie("The Lord of the rings", 8.8f), new Movie("The Avengers", 6.0f)};
        String[] hobbies = {"Photograph", "Videogames", "Youtube"};
        Address address =  new Address("Street 1", null, 49069);
        Employee employee = new Employee("Jhon", "Wick", "Developer", 200.3f, true, address, hobbies, favoriteMovies);

        System.out.println(objectToJson(employee, 0));
    }

    public static String objectToJson(Object instance, int indentSize) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder json = new StringBuilder();

        json.append("{");
        json.append("\n");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if(field.isSynthetic()) {
                continue;
            }

            json.append(indentString(indentSize+1));
            json.append(formatString(field.getName()));
            json.append(":");

            field.setAccessible(true);
            if(field.getType().isPrimitive()) {
                json.append(formatPrimitive(field.get(instance), field.getType()));
            } else if (String.class.equals(field.getType())) {
                json.append(formatString(field, instance));
            } else if (field.getType().isArray()) {
                json.append(arrayToJson(field.get(instance), indentSize + 1));
            } else {
                json.append(objectToJson(field.get(instance), indentSize + 1));
            }

            if(i != (fields.length-1)) {
                json.append(",");
            }

            json.append("\n");
        }

        json.append(indentString(indentSize));
        json.append("}");
        return json.toString();
    }

    private static String indentString(int indentSize) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < indentSize; i++) {
            builder.append("\t");
        }
        return builder.toString();
    }

    private static String arrayToJson(Object arrayInstance, int indentSize) throws IllegalAccessException {
        StringBuilder builder = new StringBuilder();
        int arrayLength = Array.getLength(arrayInstance);
        Class<?> arrayType = arrayInstance.getClass().getComponentType();

        builder.append("[");
        builder.append("\n");

        for(int i = 0; i < arrayLength; i++) {
            Object value = Array.get(arrayInstance, i);

            builder.append(indentString(indentSize + 1));
            if(arrayType.isPrimitive()) {
                builder.append(formatPrimitive(value, arrayType));
            } else if (String.class.equals(arrayType)) {
                builder.append(formatString(value.toString()));
            } else {
                builder.append(objectToJson(value, indentSize + 1));
            }

            if(i != arrayLength - 1) {
                builder.append(",");
            }
            builder.append("\n");
        }

        builder.append(indentString(indentSize));
        builder.append("]");

        return builder.toString();
    }

    private static String formatPrimitive(Object instance, Class<?> type) throws IllegalAccessException {
        if (boolean.class.equals(type)
        || int.class.equals(type)
        || long.class.equals(type)
        || short.class.equals(type)) {
            return instance.toString();
        } else if (double.class.equals(type) || float.class.equals(type)) {
            return String.format("%.02f", instance);
        }

        throw new RuntimeException(String.format("Type : %s is unsupported", type.getTypeName()));
    }

    private static String formatString(Field field, Object parentInstance) throws IllegalAccessException {
        if(Objects.isNull(field.get(parentInstance))) {
            return "\"null\"";
        }
        return String.format("\"%s\"", field.get(parentInstance));
    }

    private static String formatString(String value) {
        return String.format("\"%s\"", value);
    }

}

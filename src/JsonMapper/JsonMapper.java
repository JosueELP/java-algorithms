package JsonMapper;

import Data.Address;
import Data.Employee;

import java.lang.reflect.Field;
import java.util.Objects;

public class JsonMapper {

    public static void main(String[] args) throws IllegalAccessException {
        Address address =  new Address("Street 1", null, 49069);
        Employee employee = new Employee("Jhon", "Wick", "Developer", 200.3f, true, address);

        System.out.println(objectToJson(employee, 0));
    }

    public static String objectToJson(Object instance, int indentSize) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder json = new StringBuilder();

        json.append(indentString(indentSize));
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
                json.append(formatPrimitive(field, instance));
            } else if (String.class.equals(field.getType())) {
                json.append(formatString(field, instance));
            } else {
                json.append(objectToJson(field.get(instance), indentSize+1));
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

    private static String formatPrimitive(Field field, Object parentInstance) throws IllegalAccessException {
        if (boolean.class.equals(field.getType())
        || int.class.equals(field.getType())
        || long.class.equals(field.getType())
        || short.class.equals(field.getType())) {
            return field.get(parentInstance).toString();
        } else if (double.class.equals(field.getType()) || float.class.equals(field.getType())) {
            return String.format("%.02f", field.get(parentInstance));
        }

        throw new RuntimeException(String.format("Type : %s is unsupported", field.getType().getName()));
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

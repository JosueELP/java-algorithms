import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFlattening {

    public static void main(String[] args) {
        //example 1
        Integer[] example1 = concat(Integer.class, 1,2,3,4,5,6);

        //example 2
        int[] example2 = concat(int.class, 1,2,3,new int[] {4,5,6}, 7);

        //example 3
        String[] example3 = concat(String.class, new String[] {"a","b"}, "c", new String[] {"d","e"});

        System.out.println("Example 1: ");
        System.out.println(Arrays.toString(example1));

        System.out.println("Example 2: ");
        System.out.println(Arrays.toString(example2));

        System.out.println("Example 3: ");
        System.out.println(Arrays.toString(example3));
    }

    public static <T> T concat(Class<?> type, Object... arguments) {
        if(arguments.length == 0) {
            return null;
        }

        List<Object> elementList = new ArrayList<>();
        for(int i = 0; i < arguments.length; i++) {
            Object argumentValue = arguments[i];
            if(argumentValue.getClass().isArray()) {
                for(int j = 0; j < Array.getLength(argumentValue); j++) {
                    elementList.add(Array.get(argumentValue, j));
                }
            } else {
                elementList.add(argumentValue);
            }
        }

        Object arrayFlattened = Array.newInstance(type, elementList.size());
        for(int i = 0; i < elementList.size(); i++) {
            Array.set(arrayFlattened, i, elementList.get(i));
        }

        return (T) arrayFlattened;
    }

}

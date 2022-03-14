import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Find a number in an array with streams
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int numberToFind = 11;

        Boolean isNumberInArray = Arrays.stream(array).anyMatch(n -> n == numberToFind);
        System.out.println(isNumberInArray);
        System.out.println("--------------------------------");

        //Bubble Sort Algorithm
        int[] array2 = {6,7,3,5,2,5,1,8,10};

        for(int i = 0; i < array2.length - 1; i++){
            for(int j = 0; j < array2.length - i - 1; j++){
                if(array2[j] > array2[j+1]){
                    int temp = array2[j+1];
                    array2[j+1] = array2[j];
                    array2[j] = temp;
                }
            }
        }

        for (int number : array2) {
            System.out.println(number);
        }

        System.out.println("--------------------------------");

        //Stream sorted array
        int[] array3 = {6,7,3,5,2,5,1,8,10};

        array3 = Arrays.stream(array3).sorted().toArray();
        Arrays.stream(array3).forEach(System.out::println);

        System.out.println("--------------------------------");

        List<Integer> listOfNumbers = new ArrayList<>(Arrays.asList(1,5,3,6,7,10,8,9));
//        listOfNumbers = listOfNumbers.stream().filter(number -> number >= 5).collect(Collectors.toList());
//        listOfNumbers.forEach(System.out::println);
//
//        System.out.println("--------------------------------");
//
//        listOfNumbers = listOfNumbers.stream().map(number -> number * 2).collect(Collectors.toList());
//        listOfNumbers.forEach(System.out::println);

        listOfNumbers = listOfNumbers.stream()
                .filter(number -> number >= 5)
                .map(number -> number * 10)
                .collect(Collectors.toList());

        listOfNumbers.forEach(System.out::println);

    }
}

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {1,8,5,4,9,3,6,2,7,10};

        bubbleSort(numbers);

        Arrays.stream(numbers).forEach(System.out::println);
    }

    public static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if(numbers[j] > numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
}

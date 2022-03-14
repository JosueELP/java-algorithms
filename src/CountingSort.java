import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] numbers = {1,8,5,4,9,3,6,2,7,10};
        int[] sortedNumbers;

        sortedNumbers = countingSort(numbers);

        Arrays.stream(sortedNumbers).forEach(System.out::println);
    }

    public static int[] countingSort(int[] numbers) {
        int[] countingArray = new int[numbers.length+1];
        int[] sortedNumbers = new int[numbers.length];

        for (int number : numbers) {
            countingArray[number]++;
        }

        for(int i = 1; i < countingArray.length; i++) {
            countingArray[i] += countingArray[i-1];
        }

        for(int i = numbers.length - 1; i >= 0; i--) {
            int current = numbers[i];
            sortedNumbers[countingArray[current] - 1] = current;
            countingArray[current]--;
        }

        return sortedNumbers;
    }
}

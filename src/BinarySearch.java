public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int low, high;
        int numberToFind = 7;

        low = 0;
        high = numbers.length - 1;

        if(binarySearch(low, high, numbers, numberToFind)){
            System.out.println("ENCONTRADO");
        }else{
            System.out.println("NO ENCONTRADO");
        }
    }

    public static boolean binarySearch(int low, int high, int[] numbers, int numberToFind){
        int mid = low + (high - low) / 2;
        boolean found = false;

        if(high >= low){
            if(numberToFind == numbers[mid]){
                found = true;
            }
            else if(numberToFind > numbers[mid]) {
                low = mid + 1;
                found = binarySearch(low, high, numbers, numberToFind);
            }
            else if(numberToFind < numbers[mid]){
                high = mid - 1;
                found = binarySearch(low, high, numbers, numberToFind);
            }
        }

        return found;
    }
}

import java.time.LocalDate;
import java.time.LocalTime;

public class Random {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(generateRandomNumber());
        }
    }

    public static int generateRandomNumber(){
        LocalTime time = java.time.LocalTime.now();
        long SEED = time.getHour()+time.getMinute()+time.getSecond()+time.getNano();
        int randomNumber = (int) (SEED * 65532);
        randomNumber = randomNumber / 228064123;
        return randomNumber;
    }
}

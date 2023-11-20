import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> result = new HashMap<>();
        Map<Integer, String> result2 = new HashMap<>();
        int[] doors = {0, 0, 0};
        makeChoice(doors, result, 1);
        makeChoice(doors, result2, 0);

        //Не меняем выбор
        int wins = countWins(result);
        int loses = 1000 - wins;
        System.out.println("Первый вариант (не меняем выбор).");
        System.out.println("Количество побед: " + wins);
        System.out.println("Количество поражений: " + loses);
        System.out.println();

        // Меняем выбор
        wins = countWins(result2);
        loses = 1000 - wins;

        System.out.println("Второй вариант (меняем выбор)");
        System.out.println("Количество побед: " + wins);
        System.out.println("Количество поражений: " + loses);
    }

    public static void makeChoice (int[] array, Map<Integer, String> result, int winFlag) {
        Random rnd = new Random();
        int choice;
        for (int i = 0; i < 1000; i++) {
            int doorNumber = rnd.nextInt(3);
            array[doorNumber] = 1;
            choice = rnd.nextInt(3);
            if (array[choice] == winFlag) {
                result.put(i, "Win");
            } else {
                result.put(i, "Lose");
            }
            array[doorNumber] = 0;
        }
    }
    public static int countWins (Map<Integer, String> result) {
        int wins = 0;
        for (String s : result.values()) {
            if (s.equals("Win")) {
                wins++;
            }
        }
        return wins;
    }
}

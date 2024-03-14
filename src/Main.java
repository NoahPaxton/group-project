package src;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static final String BOMB = "\uD83D\uDCA3";
    static final String GREEN_APPLE = "\uD83C\uDF4F";
    static final String RED_APPLE = "\uD83C\uDF4E";
    static final String BANANA = "\uD83C\uDF4C";
    static final String MELON = "\uD83C\uDF48";
    static final String GRAPES = "\uD83C\uDF47";
    static final String KIWI = "\uD83E\uDD5D";
    static final String STRAWBERRY = "\uD83C\uDF53";

    static final String[] SPINNER_VALUES = new String[]{
            BOMB,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,
    };

    public static int option() {
        Scanner input = new Scanner(System.in);
        int number = 0;
        int i = 0;
        while (i == 0) {
            try {
                number = Integer.parseInt(input.next());
                i++;
            } catch (NumberFormatException e) {
                System.out.println("the input was not a number try again");
            }
        }
        i = 0;
        return number;

    }

    public static int menu() {
        System.out.format("Main Menu%n1) Play%n2) Quit%n");
        int option = option();
        return option;
    }

    public static String[] runSlotGame(int size) {
        String[] lotteryResult = new String[size];
        for (int i = 0; i < size; i++) {
            int randomIndex = (int) Math.floor(Math.random() * SPINNER_VALUES.length);
            lotteryResult[i] = SPINNER_VALUES[randomIndex];
        }
        return lotteryResult;
    }

    public static boolean areTheSame(String[] array) {
        for (int i = 1; i < array.length; i++) {
            if (!Objects.equals(array[i - 1], array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("One-Armed Bandit Bonanza");

        int option;
        do {
            option = menu();

            if (option == 1) {
                int lotterySize = 3;
                String[] resultFruits = runSlotGame(lotterySize);
                System.out.println(String.join(" ", resultFruits));

                // BOMB
                if(Arrays.asList(resultFruits).contains(BOMB)){
                    System.out.println("GAME OVER");
                    System.exit(0);
                    return;
                }

                if(areTheSame(resultFruits)){
                    System.out.println("You have won!");
                } else {
                    System.out.println("Try again!");
                }

                System.out.println();
            }
        } while (option == 1);
    }
}

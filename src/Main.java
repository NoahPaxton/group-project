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
    //These strings are static final because they do not need to change, and we do not want them to change throughout the project. The value will always remain the same. 
    //The values of the strings here are all UTF-16 Unicode values for the respective emojis. 
    
    static final String[] SPINNER_VALUES = new String[]{
            BOMB,
            GREEN_APPLE, RED_APPLE, BANANA, MELON, GRAPES, KIWI, STRAWBERRY,

    };
    //This array contains all the values available to the code that accesses this array. 
    
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
        //Error handling is implemented using a while loop so that it will not 
        //exit when someone enters something other than 1 or 2. 
    }

    public static int menu() {
        System.out.format("Main Menu%n1) Play%n2) Quit%n");
        int option = option();
        return option;
    }

    //The menu subroutine when called will display then call the option subroutine so an option can be input by the
    //user.
  
    
    public static String[] runSlotGame(int size) {
        String[] lotteryResult = new String[size];
        for (int i = 0; i < size; i++) {
            int randomIndex = (int) Math.floor(Math.random() * SPINNER_VALUES.length);
            lotteryResult[i] = SPINNER_VALUES[randomIndex];
        }
        return lotteryResult;
        //This subroutine runs the slot function and gives out three random values from the array. 
    }

    public static boolean areTheSame(String[] array) {
        for (int i = 1; i < array.length; i++) {
            if (!Objects.equals(array[i - 1], array[i])) {
                return false;
            }
        }
        return true;
        //This subroutine handles the lotteryResult. 
        //If objects do not equal the same, it will return false and if they do equal the same it will return true. 
    }

    public static void main(String[] args) {
        System.out.println("One-Armed Bandit Bonanza");

        int option;
        int gameCount = 1;
        int gameWon = 0;
        do {
            option = menu();

            if (option == 1) {
                System.out.printf("Game #%d (Games won: %d)%n%n", gameCount++, gameWon);
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
                    gameWon++;
                } else {
                    System.out.println("Try again!");
                }

                System.out.println();
            }
        } while (option == 1);
        System.out.println("game has quit");
        //the main section calls all the subroutine when required. 
        //It also includes a section where if the resultFruits contains a bomb it will game over.
        //A while loop is used so that if 1 is selected the main menu will be shown again after being run once.
        //main will only run while option = 1, if option doesn't equal 1 and is a number, the program will then print
        //"game has quit" and then the program will exit.
    }
}

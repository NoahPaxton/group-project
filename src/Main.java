package src;

import java.util.Scanner;

public class Main {

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
        i=0;
        return number;

    }


    public static void menu(int option){
        System.out.format("Main Menu %n 1) Play %n 2) Quit ");
        if (option() == 1) {
            System.out.println("placeholder");

        } else if (option() == 2) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

    }
}




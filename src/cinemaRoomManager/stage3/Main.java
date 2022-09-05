package cinemaRoomManager.stage3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();

        String[][] arrays = new String[rows + 1][columns + 1];
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                if (i == 0 && j == 0) {
                    arrays[i][j] = " ";
                } else if (i == 0) {
                    arrays[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    arrays[i][j] = String.valueOf(i);
                } else {
                    arrays[i][j] = "S";
                }
            }
        }
        System.out.println("Cinema:");
        for (String[] array : arrays) {
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        //ticket price
        int ticketPrice;

        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        if (rows * columns <= 60) {
            ticketPrice = 10;
        } else if (rows * columns > 60 && rowNumber > rows / 2){
            ticketPrice = 8;
        } else {
            ticketPrice = 10;
        }

        System.out.println("Ticket Price: $" + ticketPrice);

        System.out.println("Cinema:");

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                arrays[rowNumber][seatNumber] = "B";
            }
        }

        for (String[] array : arrays) {
            for (String s : array) {
                System.out.print(s + " ");
            }
            System.out.println();
        }



    }


}

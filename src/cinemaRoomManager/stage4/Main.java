package cinemaRoomManager.stage4;



import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();

        String emptySeats = "S ";
        String filledSeats = "B ";

        String[][] arrays = cinemaSeating(rows, columns, emptySeats);


        theatreMenu(arrays, rows, columns);

    }


    public static void theatreMenu(String[][] arrays, int rows, int columns) {

        Scanner menuInput = new Scanner(System.in);
        boolean exit = true;
        String menuMessage = ("1. Show the seats \n" +
                "2. Buy a ticket \n" +
                "0. Exit");


        do {
            System.out.println(menuMessage);
            int menuOption = menuInput.nextInt();
            System.out.print("\n");

            switch (menuOption) {
                case 1:
                    printTheatre(arrays, rows, columns);
                    break;
                case 2:
                    fillSeat(arrays, rows, columns);
                    System.out.print("\n");
                    break;
                case 0:
                    exit = false;
                    menuInput.close();
                    break;
            }
        }
        while (exit);
    }

    private static void printTheatre(String[][] cinema, int cinemaLength, int cinemaWidth) {

        System.out.print("Cinema:\n  ");

        for (int i = 0; i < cinemaWidth; i++) {
            System.out.print(i + 1 + " ");
        }

        System.out.println();

        for (int i = 0; i < cinemaLength; i++) {
            for (int j = 0; j < cinemaWidth; j++) {
                if (j == 0) {
                    System.out.print((i + 1) + " " + cinema[i][j]);
                } else {
                    System.out.print(cinema[i][j]);
                }
            }

            System.out.println();
        }
    }

    private static void fillSeat(String[][] cinema, int cinemaLength, int cinemaWidth) {

        int seatPrice = 0;
        int frontRows = (cinemaLength / 2) - 1;
        int backRows = (cinemaLength / 2) + 1;
        int seats = cinemaLength * cinemaWidth;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowPick = scanner.nextInt() - 1;

        System.out.println("Enter a seat number in that row:");
        int seatPick = scanner.nextInt() - 1;

        if (cinema[rowPick][seatPick].equals("S ")) {
            cinema[rowPick][seatPick] = "B ";
        }

        if (seats <= 60) {
            System.out.println("Ticket Price:" + "\n" + "$10" + "\n");
        } else if (seats > 60 && rowPick <= frontRows) {
            System.out.println("Ticket Price:" + "\n" + "$10" + "\n");
        } else
            System.out.println("Ticket Price:" + "\n" + "$8" + "\n");

        printTheatre(cinema, cinemaLength, cinemaWidth);
    }


    private static String boxOffice(int cinemaLength, int cinemaWidth) {

        int seatPrice = 0;
        int frontRows = 0;
        int backRows = 0;

        //Small theatre to Large size theatre
        int seats = cinemaLength * cinemaWidth;
        int sales = 0;


        if (seats <= 60) {
            seatPrice = 10;
            sales = seats * seatPrice;
        }
        if (seats > 60 && seats % 2 != 0) {
            frontRows = (cinemaWidth - 1) / 2;
            sales = frontRows * 10;
            backRows = (cinemaWidth + 1) / 2;
            sales += backRows * 8;
        }
        if (seats > 60 && seats % 2 == 0) {
            frontRows = cinemaWidth / 2;
            sales = frontRows * 10;
            backRows = cinemaWidth / 2;
            sales += backRows * 8;
        }
        System.out.println("Total income:\n" + "$" + sales);
        return String.valueOf(sales);
    }

    private static String[][] cinemaSeating(int cinemaLength, int cinemaWidth, String openSeat) {

        String[][] cinema = new String[cinemaLength][cinemaWidth];
        for (String[] row : cinema) {
            Arrays.fill(row, openSeat);
        }
        return cinema;
    }
}
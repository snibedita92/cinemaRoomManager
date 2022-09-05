package cinemaRoomManager.stage2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int noRow = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int noSeat = scanner.nextInt();
        int totalSeat = noSeat * noRow;
        if (totalSeat <= 60) {
            int income = totalSeat * 10;
            System.out.println("Total income:");
            System.out.println("$" + income);
        }
        if (totalSeat > 60) {
            if (noRow % 2 == 0) {
                int frontRow = noRow / 2;
                int lastRow = noRow / 2;
                int income = (frontRow *noSeat * 10) + (lastRow * noSeat * 8);
                System.out.println("Total income:");
                System.out.println("$" + income);

            } else  {
                int frontRow = noRow / 2;

                int lastRow = noRow - frontRow;
                int income = (frontRow *noSeat * 10) + (lastRow * noSeat * 8);
                System.out.println("Total income:");
                System.out.println("$" + income);

            }
        }

    }
}

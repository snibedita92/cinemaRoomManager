package cinemaRoomManager.stage5;




import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your code here

        int soldTickets = 0;
        int currentProfit = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int cols = sc.nextInt();

        String[][] cinema = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cinema[i][j] = "S";
            }
        }
        int numberOfSeats = rows * cols;
        printMenu();

        int nextAction = sc.nextInt();

        while (nextAction != 0){
            if (nextAction == 1){
                printCinema(rows, cinema);
            }
            else if (nextAction == 2){
                // System.out.println();
                currentProfit += buyTicket(cinema, cols,rows, currentProfit);
                soldTickets ++;

            }
            else if (nextAction == 3){
                statistics(numberOfSeats,rows,cols,soldTickets,currentProfit);
            }
            printMenu();
            nextAction = sc.nextInt();
        }

    }

    public static void statistics(int numberSeats, int numberRows, int numCols, int soldTickets,
                                  int currentProfit){
        System.out.println();

        System.out.println("Number of purchased tickets: " + soldTickets);
        System.out.println("Percentage: " + String.format("%.2f",(double)soldTickets /(double) numberSeats * 100) + "%");
        System.out.println("Current income: $"+ currentProfit);
        calculateProfit( numberSeats,  numberRows,  numCols);
    }

    public static void printMenu (){
        System.out.println();

        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }

    public static void printCinema(int rows, String[][] cinema){
        System.out.println();
        System.out.println("Cinema:");
        //  System.out.println("  1 2 3 4 5 6 7 8");
        System.out.print("  ");
        for (int k = 1; k <= rows + 1; k++) {
            System.out.print(k + " ");
        }
        System.out.println();

        for (int i = 0; i < cinema.length; i++) {

            System.out.print((i + 1) + " ");
            for (int j = 0; j < cinema[i].length; j++) {

                System.out.print(cinema[i][j] + " ");
            }

            System.out.println();
        }
        System.out.println();

    }
    public static int calculateTicketPrice(int numberSeats, int numberRows, int chosenRow){
        int ticketPrice = 10;
        int backRowsTicketPrice = 8;
        // System.out.println();
        if (numberSeats > 60 && chosenRow > (numberRows / 2)){
            ticketPrice = backRowsTicketPrice;

        }
        return ticketPrice;
    }

    public static void calculateProfit(int numberSeats, int numberRows, int numCols){
        int ticketPrice = 10;
        int backRowsTicketPrice = 8;
        int totalPrice;
        if (numberSeats > 60){
            if (numberRows % 2 == 0){
                totalPrice = numCols * (numberRows/2) * ticketPrice + numCols * (numberRows/2) * backRowsTicketPrice;
            }
            else {
                totalPrice = (numCols * (numberRows - (numberRows/2)) * backRowsTicketPrice) + (numCols * (numberRows/2) * ticketPrice);
            }

        }
        else {
            totalPrice = numberSeats * ticketPrice;
        }

        System.out.println("Total income: $" + totalPrice);

    }

    public static boolean validTicketInput(int chosenRow, int chosenCol, String[][] cinema, int cols){
        if (chosenRow > cinema.length || chosenRow < 0 ||
                chosenCol > cols || chosenCol < 0){
            System.out.println("Wrong input!");
            System.out.println();
            return false;
        }
        return true;
    }


    public static boolean validTicketToPurchase(int chosenRow, int chosenCol, String[][] cinema){


        if ("B".equals(cinema[chosenRow-1][chosenCol-1])) {
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            return false;
        }

        return true;
    }

    public static int buyTicket(String[][] matrix, int cols, int row, int currentProfit){
        Scanner sc = new Scanner(System.in);
        //  System.out.println();
        System.out.println("Enter a row number:");
        int chosenRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int chosenCol = sc.nextInt();


        if (validTicketInput(chosenRow, chosenCol, matrix, cols)){
            if (validTicketToPurchase(chosenRow, chosenCol, matrix)) {
                //  System.out.println("Ticket price: $" + calculateTicketPrice(row *cols, row, chosenRow));
                matrix[chosenRow - 1][chosenCol - 1] = "B";
                currentProfit = calculateTicketPrice(row *cols, row, chosenRow);
                System.out.println("Ticket price:$" + calculateTicketPrice(row *cols, row, chosenRow));
                //  System.out.println("Ticket price:"+ " $"+ calculateTicketPrice(row *cols, row, chosenRow));

            }else {
                buyTicket(matrix, cols, row, currentProfit);
            }
        }else buyTicket(matrix, cols, row, currentProfit);

        return currentProfit;


    }
}
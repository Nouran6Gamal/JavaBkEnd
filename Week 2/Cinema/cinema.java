import java.util.Scanner;

class Main {

    static Scanner sc = new Scanner(System.in);

    static void displayAll(char[][] seats) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.println("row" + i + "," + "col" + j + "=" + seats[i][j]);
            }
        }
    }

    // Book a seat after validating row and seat numbers.
    static void book(char[][] seats) {

        System.out.println("Enter seat row");
        int seat_row = sc.nextInt();

        System.out.println("Enter seat col");
        int seat_col = sc.nextInt();

        // to decrease both variables to be the same values for arr indices
        seat_row--;
        seat_col--;

        // Validate row numbers (1-5) and seat numbers (1-6)
        if (!((seat_col >= 0 && seat_col < 6) && (seat_row >= 0 && seat_row < 5))) {
            System.out.println("Invalid col or row");
        } else {

            if (seats[seat_row][seat_col] == '0') {
                seats[seat_row][seat_col] = 'X';
            } else {
                System.out.println("seat is booked , choose another one");
                System.out.println("Enter seat col");
                book(seats);
            }
        }
    }

    // Cancel an existing booking.
    static void cancel(char[][] seats) {

        System.out.println("Enter seat col");
        int seat_col = sc.nextInt();

        System.out.println("Enter seat row");
        int seat_row = sc.nextInt();

        seat_row--;
        seat_col--;

        if (seats[seat_row][seat_col] == 'X') {
            seats[seat_row][seat_col] = '0';
        } else {
            System.out.println("seat is booked , choose another one");
            System.out.println("Enter seat col");

            cancel(seats);
        }
    }

    // Display booked seats, available seats.
    static void displayBookedAvailable(char[][] seats) {

        int booked = 0;
        int avail = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {

                if (seats[i][j] == '0') {
                    System.out.println("row" + i + "," + "col" + j + "=" + "is available");
                    avail++;
                }
            }
        }

        for (int m = 0; m < 5; m++) {
            for (int n = 0; n < 6; n++) {

                if (seats[m][n] == 'X') {
                    System.out.println("row" + n + "," + "col" + m + "=" + "is booked");
                    booked++;
                }
            }
        }

        System.out.println("no of booked = " + booked + ", no of available =" + avail);

        // Display 'Almost Full' when occupancy exceeds 80%.
        if (booked >= 24) {
            System.out.println("Almost Full");
        }
    }

    static void ShowAllMovies(String[] movieNames1) {

        System.out.println("Enter movies number");
        int noMovies = sc.nextInt();

        for (int i = 0; i < noMovies; i++) {

            System.out.println("Enter movie name");
            movieNames1[i] = sc.next();
        }

        System.out.println("no of movies = " + noMovies);

        for (int j = 0; j < noMovies; j++) {
            System.out.println(movieNames1[j]);
        }
    }

    static void exit() {
        System.out.println("Thanks for using our Tickets System");
    }

    public static void main(String[] args) {

        boolean status = true;

        char[][] seats = new char[5][6];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                seats[i][j] = '0';
            }
        }

        String[] movieNames1 = new String[20];

        do {

            String[] movieNames = {"Superman", "Avatar", "Minecraft", "Inside Out", "F1"};

            System.out.println(
                "========= Cinema =========\n" +
                "1. Display Seats\n" +
                "2. Book Seat\n" +
                "3. Cancel Booking\n" +
                "4. Show all movies\n" +
                "5. Show number of available and booked seats\n" +
                "0. Exit\n" +
                "======================="
            );

            System.out.println("Enter Option");
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    displayAll(seats);
                    break;

                case 2:
                    book(seats);
                    break;

                case 3:
                    cancel(seats);
                    break;

                case 4:
                    ShowAllMovies(movieNames1);
                    break;

                case 5:
                    displayBookedAvailable(seats);
                    break;

                case 0:
                    exit();
                    status = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (status);
    }
}

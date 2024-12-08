import java.util.Scanner;

public class BoardLogic {

    Scanner scanner = new Scanner(System.in);
    private Board board = null;
    private int timesChanged = 0;

    // Constructor for the whole program, if skipStart is true then it will create a random sized board
    public BoardLogic(boolean skipStart) {
        if (skipStart) {
            Board board = new Board();
            options();
        }
    }

    // Allows user input to create a board
    public void start() {
        System.out.print("Enter board dimensions: ");
        String dimensions = scanner.nextLine();
        int horizontal = Integer.parseInt(dimensions.substring(0, 1));
        int vertical = Integer.parseInt(dimensions.substring(2));
        board = new Board(horizontal, vertical);
        board.printBoard();
        options();
    }

    // Allows user input to choose what to do next
    public void options() {
        System.out.print("Type 1 to print the board\nType 2 to change a square\n");
        if (scanner.nextInt() == 1) {
            board.printBoard();
        } else {
            timesChanged++;
            scanner.nextLine();
            System.out.print("Input coordinates, or leave blank to change a random square: ");
            String coordinates = scanner.nextLine();
            if (coordinates.equals("")) {
                board.changeSquare();
            } else {
                int firstNumEnd = coordinates.indexOf(",");
                int secondNumEnd = coordinates.indexOf(")");
                board.changeSquare(Integer.parseInt(coordinates.substring(1, firstNumEnd)), Integer.parseInt(coordinates.substring(firstNumEnd + 2, secondNumEnd)));
                }
            }
        if (timesChanged == 1) {
            System.out.println("The board has been changed " + timesChanged + " time");
        } else {
            System.out.println("The board has been changed " + timesChanged + " times");
        }
        options();
    }
}

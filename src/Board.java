public class Board {

    private String boardString = "";
    private int horizontal;
    private int vertical;

    // Creates a board with a size based on the input
    public Board(int horizontal, int vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        for (int current = 0; current < horizontal * vertical; current++) {
            boardString += "o";
        }
    }

    // No input constructor, creates random sized board with maximum 10 side length
    public Board() {
        horizontal = (int) ((Math.random() * 10 + 1));
        vertical = (int) ((Math.random() * 10 + 1));
        for (int current = 0; current < horizontal * vertical; current++) {
            boardString += "o";
        }
    }

    // Checks if a square is activated or not using coordinates
    private boolean checkSquare(int x, int y) {
        int location = ((y - 1) * horizontal + x) - 1;
        if (boardString.substring(location, location + 1).equals("x")) {
            return true;
        }
        return false;
    }

    // Changes a square based on coordinates, recreates the string but replaces the target location
    public void changeSquare(int x, int y) {
        int location = ((y - 1) * horizontal + x) - 1;
        if (x > horizontal || y > vertical) {
            System.out.println("Out of bounds");
        } else if (checkSquare(x, y)) {
            boardString = boardString.substring(0, location) + "o" + boardString.substring(location + 1);
        } else {
            boardString = boardString.substring(0, location) + "x" + boardString.substring(location + 1);
        }
    }

    public void changeSquare() {
        int x = (int) (Math.random() * horizontal) + 1;
        int y = (int) (Math.random() * vertical) + 1;
        int location = ((y - 1) * horizontal + x) - 1;
        if (x > horizontal || y > vertical) {
            System.out.println("Out of bounds");
        } else if (checkSquare(x, y)) {
            boardString = boardString.substring(0, location) + "o" + boardString.substring(location + 1);
        } else {
            boardString = boardString.substring(0, location) + "x" + boardString.substring(location + 1);
        }
    }

    // Prints the board, if a square is activated it is filled in, if it is deactivated it is not filled in
    public void printBoard() {
        for (int y = 1; y <= vertical; y++) {
            for (int x = 1; x <= horizontal; x++) {
                if (checkSquare(x, y)) {
                    System.out.print("◼  ");
                } else {
                    System.out.print("▤  ");
                }
            }
            System.out.println();
        }
    }
}

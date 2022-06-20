import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("MS_SHOULD_BE_FINAL")
    public static List<Pieces> plays = new ArrayList<>();

    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public static void main(String[] args) {
        char player1 = 'X';
        char player2 = 'O';
        Scanner input = new Scanner(System.in);

        Board gameBoard = new Board(3, 3);

        char turn = player1;
        boolean stop = false;

        String winner = "";
        gameBoard.printBoard();
        while (!stop) {
            boolean goodPlay = false;
            if (turn == player1) {
                if (gameBoard.spaceAvailable()) {
                    do {
                        System.out.print("Enter [row, col]: ");
                        int row = input.nextInt();
                        int col = input.nextInt();
                        goodPlay = gameBoard.play(turn, row - 1, col - 1);
                    } while (!goodPlay);
                } else {
                    goodPlay = false;
                }
            } else {
                goodPlay = gameBoard.autoPlay(turn);
            }
            if (goodPlay) {
                if (gameBoard.haveAWinner()) {
                    winner = "Player " + turn + " is the Winner!";
                    stop = true;
                } else {
                    turn = (turn == player1) ? player2 : player1;
                }
            } else {
                winner = "Draw!";
                stop = true;
            }
            gameBoard.printBoard();

            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {

            }
        }
        gameBoard.printBoard(winner);
        System.out.println("\n*** Plays Made ***");
        plays.forEach(System.out::println);
    }
}

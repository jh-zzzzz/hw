import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        System.out.println("Enter name of player:");
        Player player = new Player(scanner.nextLine(), deck);
        Blackjack blackjack = new Blackjack(scanner, player, deck);
        blackjack.startGame();
    }
}
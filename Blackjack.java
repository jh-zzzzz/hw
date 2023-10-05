
import java.util.Scanner;

public class Blackjack {

    private Deck deck;
    private Scanner scanner;
    private Player dealer;
    private Player player;
    private Boolean gameOver;

    public Blackjack(Scanner scanner, Player player, Deck deck) {
        this.deck = deck;
        this.scanner = scanner;
        this.dealer = new Player("Dealer", deck);
        this.player = player;
        this.gameOver = false;
    }

    public void startGame() {
        this.initialDraws();

        if (!player.hasBlackjack()) {
            this.playerDraws();
        } else {
            System.out.println(player.getName() + " has blackjack!");
        }

        if (!gameOver) {
            this.dealerDraws();
        }
        this.gameOutcome();
    }

    private void initialDraws() {
        player.drawCard();
        System.out.println(player.getName() + " draws " + player.lastDrawnCard());

        dealer.drawCard();
        System.out.println("Dealer draws " + dealer.lastDrawnCard());
        dealer.drawCard();
        System.out.println("\nDealer also draws the hole card. It is face-down, though.\n");

        player.drawCard();
        System.out.println("Second card for " + player.getName() + ": " + player.lastDrawnCard());
        System.out.println("\n" + player.getName() + "'s hand: " );
        player.printHand();
    }

    public void playerDraws() {
        while (true) {
            System.out.println("Hit or stay? enter <s> to stay");
            if (scanner.nextLine().equalsIgnoreCase("s")) {
                System.out.println(player.getName() + " stays at " + player.handValue() + ".");
                break;
            }
            player.drawCard();
            System.out.println(player.getName() + " draws " + player.lastDrawnCard());
            System.out.println("Hand value: " + player.handValue());
            if (player.hasBlackjack()) {
                System.out.println(player.getName() + " has blackjack!");
                break;
            }
            if (player.isBust()) {
                System.out.println(player.getName() + " busts!");
                this.gameOver = true;
                break;
            }
        }
    }

    public void dealerDraws() {
        System.out.println("\nHole card: " + dealer.lastDrawnCard());
        System.out.println("Dealer's hand:");
        dealer.printHand();
        while (!(dealer.isBust()) && dealer.handValue() < player.handValue()) {
            dealer.drawCard();
            System.out.println("\nDealer draws: " + dealer.lastDrawnCard());
            System.out.println("Dealer's hand's value: " + dealer.handValue());
        }
    }

    private void gameOutcome() {
        System.out.println("\n\n<<<<<GAME OUTCOME>>>>>");
        if (player.isBust()) {
            System.out.println("Dealer wins because player busted");
        } else if (dealer.isBust()) {
            System.out.println("Player wins because dealer busted");
        } else if (dealer.handValue() >= player.handValue()) {
            System.out.println("Dealer wins.\nDealer hand value: " + dealer.handValue() + "\nPlayer hand value: " + player.handValue());
        } else {
            System.out.println("Player wins.\nPlayer hand value: " + player.handValue() + "\nDealer hand value: " + dealer.handValue());
        }
    }
}

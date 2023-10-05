import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private Deck deck;

    public Player(String name, Deck deck) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.deck = deck;
    }

    public String getName() {
        return this.name;
    }

    public void drawCard() {
        hand.add(deck.drawCard());
    }

    public void printHand() {
        hand.forEach(c -> System.out.println(c));
        System.out.println("Hand value: " + this.handValue());
    }

    public int handValue() {
        int sum = 0;
        List<Card> sortedHand = this.hand.stream()
                .sorted()
                .collect(Collectors.toList());
        for (Card c : sortedHand) {
            sum += c.cardValue(sum + 11 > 21);
        }
        return sum;
    }

    public Card lastDrawnCard() {
        return this.hand.get(this.hand.size() - 1);
    }

    public Boolean hasBlackjack() {
        return handValue() == 21;
    }

    public Boolean isBust() {
        return this.handValue() > 21;
    }

    //test method
    public void addCardToHand(Card card) {
        this.hand.add(card);
    }
}

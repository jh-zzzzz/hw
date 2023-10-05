import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                this.deck.add(new Card(suit, rank));
            }
        }
    }

    //test method, gonna delete probably
    public void print() {
        deck.forEach(c -> System.out.println(c));
    }

    public Card drawCard() {
        Random random = new Random();
        int randomInteger = random.nextInt(deck.size());
        Card rCard = deck.get(randomInteger).copyCard();
        deck.remove(randomInteger);
        return rCard;
    }


    /*private String[][] deck;
    private Random randomNumberGenerator;

    public DeckOfCards() {
        this.deck = new String[][] {
                {"2,h", "3,h", "4,h", "5,h", "6,h", "7,h", "8,h", "9,h", "10,h", "10,h", "10,h", "10,h", "11,h"}, //hearts
                {"2,s", "3,s", "4,s", "5,s", "6,s", "7,s", "8,s", "9,s", "10,s", "10,s", "10,s", "10,s", "11,s"}, //spades
                {"2,d", "3,d", "4,d", "5,d", "6,d", "7,d", "8,d", "9,d", "10,d", "10,d", "10,d", "10,d", "11,d"}, //diamonds
                {"2,c", "3,c", "4,c", "5,c", "6,c", "7,c", "8,c", "9,c", "10,c", "10,c", "10,c", "10,c", "11,c"} //clubs
        };
        this.randomNumberGenerator = new Random();
    }

    public void removeFromArray(int row, int column) {
        this.deck[row][column] = "-1"; //-1 indicates card is already drawn
    }

    public String drawCard() {
        int suit = 0;
        int value = 0;
        String rString = "";
        while (true) {
            suit = randomNumberGenerator.nextInt(4);
            value = randomNumberGenerator.nextInt(13);
            rString = this.deck[suit][value];
            if (!rString.equals("-1")) {
                break;
            }
        }
        this.removeFromArray(suit, value);
        return rString;
    }*/
}
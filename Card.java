public class Card implements Comparable<Card> {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int cardValue(Boolean isCurrentlyBust) {
        if (rank == Rank.TWO) {
            return 2;
        }
        if (rank == Rank.THREE) {
            return 3;
        }
        if (rank == Rank.FOUR) {
            return 4;
        }
        if (rank == Rank.FIVE) {
            return 5;
        }
        if (rank == Rank.SIX) {
            return 6;
        }
        if (rank == Rank.SEVEN) {
            return 7;
        }
        if (rank == Rank.EIGHT) {
            return 8;
        }
        if (rank == Rank.NINE) {
            return 9;
        }
        if (rank == Rank.TEN) {
            return 10;
        }
        if (rank == Rank.JACK) {
            return 10;
        }
        if (rank == Rank.QUEEN) {
            return 10;
        }
        if (rank == Rank.KING) {
            return 10;
        }
        if (rank == Rank.ACE) {
            if (isCurrentlyBust) {
                return 1;
            }
            return 11;
        }
        return -1;
    }

    public Card copyCard() {
        return new Card(this.getSuit(), this.getRank());
    }

    public Rank getRank() {
        return this.rank;
    }

    private Suit getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card otherCard) {
        return this.getRank().compareTo(otherCard.getRank());
    }
}

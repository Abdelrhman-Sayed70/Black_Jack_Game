package blackjack;

public class Card {

    private final int suit  ; // Shape of card : 0>Clubs ♣ , 1>Diamonds ♦ , 2>Hearts ♥ , 3 Spades ♠
    private final int rank  ; // Index of shape: rank0>>card1(Ace card) , rank1>>card2 , .. , rank10>>Jack card , rank11>>Queen card , rank13>>King card
    private final int value ; // the value of each card : value of card 1 = 1 and so on ... / value of any picture = 10

    //  Parameterized constructor
    public Card(int suit , int rank , int value) {
        this.suit =suit ;
        this.rank=rank ;
        this.value=value ;
    }

    // Copy constructor
    public Card(Card card) {
        this.suit =card.suit ;
        this.rank=card.rank ;
        this.value=card.value ;
    }

    // Getters for the attributes
    public int getSuit() {
        return suit;
    }
    public int getRank() {
        return rank;
    }
    public int getValue() {
        return value;
    }

}

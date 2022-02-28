package blackjack;

public class Player {

    // attributes
    private String Name ;
    private int Score ;
    private boolean blackJac =false ; //optional
    private boolean win = false; //optional

    // array of card for each player . He has at most 11 card
    Card[] cards = new Card[11] ;

    // Getters and setters
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public int getScore() {
        return Score;
    }
    public void setScore(int score) {
        Score+= score;
    }
    public boolean isBlackJac() {
        return blackJac;
    }
    public void setBlackJac(boolean blackJac){
        this.blackJac = blackJac;
    }
    public boolean isWin() {
        return win;
    }
    public void setWin(boolean win) {
        this.win = win;
    }

    // Method used to add card to each player
    int index= 0 ;
    public void AddCard(Card c) {
        cards[index]=new Card(c) ;
        index++ ;
    }

}

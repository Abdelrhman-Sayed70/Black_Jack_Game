package blackjack;
import java.util.Random;
import java.util.Scanner;

public class Game {

    Random rand = new Random();
    Scanner input = new Scanner(System.in);

    Player[] players = new Player[4]; // p1 ,p2 ,p3 ,(dealer:is the last player at index 3 )
    Card[] cards_game = new Card[52];
    int Max=0; // keep track of VALID high score of players must be in range (0 : 21)

    // Method used to create card deck  (13 * 4)
    public void generateDeckCard() {
        // create first suit : 0
        for (int rank = 0; rank <= 12; rank++) {
            if (rank < 10) {
                cards_game[rank] = new Card(0, rank%13, rank + 1);
            } else {
                cards_game[rank] = new Card(0, rank%13, 10);
            }
        }
        // create second suit : 1
        for (int rank = 13; rank <= 25; rank++) {
            if (rank < 23) {
                cards_game[rank] = new Card(1, rank%13, rank - 12);
            } else {
                cards_game[rank] = new Card(1, rank%13, 10);
            }
        }
        // create third suit : 2
        for (int rank = 26; rank <= 38; rank++) {
            if (rank < 36) {
                cards_game[rank] = new Card(2, rank%13, rank - 25);
            } else {
                cards_game[rank] = new Card(2, rank%13, 10);
            }
        }
        // create fourth suit : 3
        for (int rank = 39; rank <= 51; rank++) {
            if (rank < 49) {
                cards_game[rank] = new Card(3, rank%13, rank - 38);
            } else {
                cards_game[rank] = new Card(3, rank%13, 10);
            }
        }
    }

    // Method that update maximum score
    public void  updateMaxScore(int s) {
        if (s>Max && s<=21) {  Max =s ; }
    }

    // Method used to draw card
    public  Card drawCard() {
        while (true) {
            int randomChoice = rand.nextInt(52); // generate random number from 0 to 51
            if (cards_game[randomChoice] != null) {
                Card temp = cards_game[randomChoice];
                cards_game[randomChoice] = null;
                return temp;
            }
        }
    }

    // Method to set information of players : give name to each player  ,  draw 2 cards random to each player
    public void setPlayers() {
        String S;
        for (int i = 0; i < 3; i++) {
            // set name for each player
            System.out.print("Enter name of " + (i+1) + " player : ");
            S = input.next();

            players[i] = new Player();
            players[i].setName(S);

            // draw 2 cards for each player then add those cards to player then add them to his score
            Card c = drawCard();
            players[i].AddCard(c);
            players[i].setScore(c.getValue());
            //updateMaxScore(players[i].getScore());

            c = drawCard();
            players[i].AddCard(c);
            players[i].setScore(c.getValue());
            //updateMaxScore(players[i].getScore());
        }
        // set info for Dealer and draw 2 cards for him ,  add those cards to him ,  then add them to his score  :
        players[3]=new Player();
        players[3].setName("Dealer");

        Card c = drawCard();
        players[3].AddCard(c);
        players[3].setScore(c.getValue());

        c = drawCard();
        players[3].AddCard(c) ;
        players[3].setScore(c.getValue());

    }

}

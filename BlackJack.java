package blackjack;
import javax.xml.validation.Validator;
import java.util.Random ;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class BlackJack {

    static Game game =new Game() ;
    static Scanner input = new Scanner(System.in) ;
    static GUI gui;

    public static void main(String[] args) {

        gui = new GUI();
        game.generateDeckCard();
        game.setPlayers();
        gui.runGUI(game.cards_game , game.players[0].cards,game.players[1].cards ,game.players[2].cards, game.players[3].cards );
        System.out.println();
        System.out.println("***************************************************************");
        PLAY();

    }

     static void PLAY() {

         int[]scores=new int[4] ;

         // Now 3 players will play :
         for (int i=0 ;i<3;i++) {
             while (true) {
                 int ScoreOfPlayer = game.players[i].getScore() ;
                 String NameOfPlayer = game.players[i].getName();
                 boolean StatusOfPlayer = game.players[i].isWin();
                 System.out.println("Current Score of " + NameOfPlayer + " is : " + ScoreOfPlayer );
                 if (ScoreOfPlayer==21) {
                     scores[i]=21 ;
                     game.players[i].setBlackJac(true);
                     game.updateMaxScore(21);
                     System.out.println( NameOfPlayer +" has BLACK JACK !" );
                     break;
                 }
                 else if (ScoreOfPlayer>21) {
                     scores[i]=0;
                     game.players[i].setWin(false);
                     System.out.println( NameOfPlayer + " is BUSTED !"  );
                     break;
                 }
                 System.out.println( NameOfPlayer+ "'s  turn .. press 1 to hit or 2 to stand");
                 int choice = input.nextInt();
                 if (choice==1) {
                     Card c = game.drawCard() ;
                     game.players[i].AddCard(c);
                     gui.updatePlayerHand(c,i) ;
                     game.players[i].setScore(c.getValue());
                     //game.updateMaxScore(ScoreOfPlayer);
                 }
                 else if (choice==2) {
                     scores[i]=game.players[i].getScore() ;
                     game.updateMaxScore(game.players[i].getScore());
                     break;
                 }
             }
             System.out.println("---------------------------");
         }

        // Now Dealer will play
        int ScoreOfDealer = game.players[3].getScore() ;
        String NameOfDealer = game.players[3].getName();
        boolean StatusOfDealer = game.players[3].isWin();
        while ( game.players[3].getScore() <= game.Max  ) {
             Card c = game.drawCard() ;
             game.players[3].AddCard(c);
             gui.updateDealerHand(c,game.cards_game) ;
             game.players[3].setScore(c.getValue());
         }
        game.updateMaxScore(game.players[3].getScore());
        System.out.println("Dealer's turn ....... ");
        scores[3]=game.players[3].getScore() ;
        System.out.println("Current score of Dealer is : " + game.players[3].getScore() );


        // Details of Round
        System.out.println("***************************************************************");
        System.out.println();
        System.out.println("Details of round ...");
        System.out.println();
        for (int i=0 ;i<4 ;i++) {
             System.out.print("score of " + game.players[i].getName() + " = " + game.players[i].getScore() +  "    "  );
             if (game.players[i].getScore()>21) {
                 System.out.print("Busted !");
             }
             else if (game.players[i].getScore()==21) {
                 System.out.print("Black jack !");
             }
             System.out.println();
        }
         System.out.println();
         System.out.println("Max score = "+ game.Max);


        // determine who is the winner :
        if (game.players[3].getScore()==21) {
            boolean push =false ;
            for (int i = 0; i < 3; i++) {
                if (game.players[3].getScore() == game.players[i].getScore())  {  push=true ; break;}
            }
            if (push==true) {
                System.out.println("It Is Push");
            }
            else {
                System.out.println("The Winner is : Dealer");
            }
        }
        else if (game.players[3].getScore()>21) {
            int mx = -1, cnt = 0, index = 0;

            for (int i = 0; i < 3; i++) {
                if (game.players[i].getScore() == game.Max) {
                    cnt++;
                    index = i;
                }
            }
            if (cnt == 1) {
                System.out.println(  "The Winner is : " + game.players[index].getName()  );
            }
            else if (cnt>1) {
                System.out.println("It Is Push");
            }
        }
        else {
            System.out.println("The Winner is : Dealer");
        }
        System.out.println();
         System.out.println("***********************************************************************************************");
     }


 }



import java.util.Scanner;

public class Nimsys {

    static Scanner input = new Scanner(System.in); //scanner
    public static Nimsys gameObj = new Nimsys();//create main game object
    public static int turnRound = 0; // count round played
    //public static int gamePlayed = 0; //count game played
    //private static String command = null; //take input into command line
    
    private boolean isRunning = true;

    public static void main(String[] args) {  //this is the main method contains commands line console input

        String command = "init";
        System.out.print("Welcome to Nim\n");
        System.out.println("\nPlease enter a command to continue ");
        System.out.print("\n$ ");


        while (!command.equals("")){
            
            System.out.print("$ ");
            command = input.nextLine().toLowerCase();

            switch (command) {
                case "commands":
                    gameObj.commandList();
                    break;
                case "start":
                    gameObj.startGame();
                    break;
                case "help":
                    gameObj.help();
                    break;

                case "exit":
                    gameObj.exit();
                    break;
            }

        } //end of while loop

    }

    private void startGame(){

        NimPlayer player_1 = new NimPlayer(null,0,0,0);
        NimPlayer player_2 = new NimPlayer(null,0,0,0);

        String p1 = null, p2 = null;

        System.out.print("\nPlease enter Player 1's name : ");

        p1 = input.nextLine();
        player_1.setName(p1);//player_1 enter name;

        System.out.print("\nPlease enter Player 2's name : ");
        p2 = input.nextLine();
        player_2.setName(p2);//player_2 enter name;

        gameObj.newtGame(player_1, player_2, p1, p2); //done

    }

    private void newtGame(NimPlayer player_1, NimPlayer player_2, String p1, String p2) {  //Start a new game.

        //String continuePlay = "Y";

        do{
            //String star = "* ";
            //gamePlayed++;  //count number of games played
            NimPlayer cUrrentPlayer = new NimPlayer();
            NimPlayer currentPlayer = null;

            System.out.print("\nEnter upper bound : ");
            int upperBound = input.nextInt();
            System.out.print("\nEnter initial number of stones : ");
            int totalStones = input.nextInt();
            //currentPlayer = player_1;//object to handle turns initialize to player_1
            currentPlayer.setTotalStone(totalStones);

            while (totalStones != 0) {
                int sn = input.nextInt();

                if (turnRound % 2 == 0) {
                    currentPlayer = player_1;
                } else {
                    currentPlayer = player_2;
                }


                System.out.print("\n" + totalStones + " stones left : ");
                gameObj.stars(currentPlayer);
                System.out.println("\n" + currentPlayer.getName() + "'s turn. Enter stones to remove : ");
                currentPlayer.setStones(sn);

                while (currentPlayer.removeStone() <= 0 || currentPlayer.removeStone() > upperBound) {
                    //this is the loop to determine whether a legal selection is provided.

                    System.out.println("Upper bound limit exceed, upper bound maximum choice is "
                            + upperBound);
                    System.out.print("\n" + currentPlayer.getName() + "'s turn. Enter stones to remove : ");
                    currentPlayer.setStones(input.nextInt());
                }

                if (currentPlayer.removeStone() > totalStones) { //check if stone number lager than remaining
                    System.out.println("Invalid attempt, only " + totalStones + " stones remaining! Try again:");
                    currentPlayer.setStones(input.nextInt());
                }

                turnRound++;  //count the turns
                totalStones = totalStones - currentPlayer.removeStone();
            }


            String win;
            if (currentPlayer.equals(player_1)){
                currentPlayer = player_2;
            }
            else{
                currentPlayer = player_1;
            }

           
            currentPlayer.setNumOfWins(currentPlayer.getWins()+1);

            System.out.println("\nGame Over"); //round ends
            System.out.println(currentPlayer.getName() + " wins!\n");
                //totalRound = 0;
            player_1.setNumOfGames(player_1.getGamesCount() + 1);  //update 1
            player_2.setNumOfGames(player_2.getGamesCount() + 1);  //update 1

            System.out.print("Do you want to play again (Y/N): ");
            String continuePlay = input.nextLine().toUpperCase();
      } while(continuePlay.equals("Y"));
        
        System.out.println("\n" + player_1.getName() + " won " + player_1.getWins() +" games out of " +
                player_1.getGamesCount() + " played");
        System.out.println(player_2.getName() + " won " + player_2.getWins() +" games out of " +
                player_2.getGamesCount() + " played");

        System.out.println("$ ");
        System.out.print("$ ");
        //command = input.nextLine();
    }//end of new game


    private void help () {  //command list method
        System.out.println("Type commands to list all available commands");
        System.out.println("Type start to play game");
        System.out.println("Player to remove the last stone loses!");
        System.out.print("\n$ ");
        String command = input.nextLine();
    }

    private void commandList(){ //command list method

        System.out.println("\n: start\r\n" + ": exit\r\n" + ": help\r\n" + ": commands");
        System.out.print("\n$ ");
        String command = input.nextLine();

    }

    private void exit(){ //command list method
        System.out.println("\nThank you for playing Nim");
        isRunning = false;
      
    }

    private void stars(Int sn){
        for (int i = 1; i <= sn; i++) {
            System.out.print("* ");
        }
    }

} //end of Nimsys class

import java.util.Scanner;

public class Nimsys {

    public static Scanner input = new Scanner(System.in); //scanner
    public static Nimsys gameObj = new Nimsys();//create main game object
    public static int turnRound = 1; // count rounds played
    private static String command = null; //take input into command line
    
    private boolean isRunning = true;

    public static void main(String[] args) {  //this is the main method contains commands line console input

        System.out.print("Welcome to Nim\n");
        System.out.println("\nPlease enter a command to continue ");
        System.out.print("\n$ ");
        command = input.nextLine().toLowerCase();
        
        while (gameObj.isRunning){
            
            System.out.print("$ ");
            command = input.nextLine().toLowerCase();

            if ("start".equals(command)) {
                gameObj.startGame();
            }
            else if ("help".equals(command)) {
                gameObj.help();
            }
            else if ("commands".equals(command)) {
                gameObj.commandList();
            }
            else if ("exit".equals(command)) {
                gameObj.exit();
            }
            else{
                System.out.println("$ ");
            }

        } //end of while loop

    }

    private void startGame(){

        NimPlayer player_1 = new NimPlayer(null,0,0,0,0);
        NimPlayer player_2 = new NimPlayer(null,0,0,0,0);

        String p1 = null, p2 = null;

        do {
            System.out.print("Please enter Player 1's name : ");

            p1 = input.nextLine();
            player_1.setName(p1);//player_1 enter name;

            System.out.print("\nPlease enter Player 2's name : ");
            p2 = input.nextLine();
            player_2.setName(p2);//player_2 enter name;

            gameObj.newtGame(player_1, player_2); //done
            break;
        }while(!command.equals("N"));
    }

    private void newtGame(NimPlayer player_1, NimPlayer player_2, String p1, String p2) {  //Start a new game.
        NimPlayer currentPlayer = null;

        do {
            //String star = "* ";

            System.out.print("\nEnter upper bound : ");
            int upperBound = input.nextInt();
            System.out.print("\nEnter initial number of stones : ");
            int totalStones = input.nextInt();
            currentPlayer = player_1;//object to handle turns initialize to player_1
            currentPlayer.setTotalStone(totalStones);

            do {

                System.out.print("\n" + totalStones + " stones left : ");
                gameObj.stars(currentPlayer);
                System.out.println("\n" + currentPlayer.getName() + "'s turn. Enter stones to remove : ");
                currentPlayer.setStones(input.nextInt());

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

                totalStones = totalStones - currentPlayer.removeStone();

                if (currentPlayer.getName().equals(player_1.getName())) {
                    currentPlayer = player_2;
                }
                else {
                    currentPlayer = player_1;
                }

                turnRound++;  //count the turns


            } while (totalStones > 0);


            System.out.println("\nGame Over"); //round ends
            
            player_1.setNumOfGames(1);
            player_2.setNumOfGames(1);
            
            String win;
            
            if (turnRound % 2 == 0) {
                win = p2;
                player_2.setNumOfWins(1);
            }
            
            else {
                win = p1;
                player_1.setNumOfWins(1);
            }    

            System.out.println(currentPlayer.getName() + " wins!\n");

        }while(input.nextLine().equals("Y"));

        System.out.print("Do you want to play again (Y/N): ");
        String playOrNot = input.nextLine().toUpperCase();

        if (playOrNot.toUpperCase().equals("Y")) {
            gameObj.newtGame(player_1, player_2);
        } else if (playOrNot.toUpperCase().equals("N")) {

            System.out.println("\n" + player_1.getName() + " won " + player_1.getWins() +" games out of " +
                    currentPlayer.getGamesCount() + " played");
            System.out.println(player_2.getName() + " won " + player_2.getWins() +" games out of " +
                    currentPlayer.getGamesCount() + " played");

            System.out.println("$ ");
            System.out.print("$ ");
            command = input.nextLine();
        }
    }//end of new game


    private void help () {  //command list method
        System.out.println("Type commands to list all available commands");
        System.out.println("Type start to play game");
        System.out.println("Player to remove the last stone loses!");
        System.out.print("\n$ ");
        command = input.nextLine();
    }

    private void commandList(){ //command list method

        System.out.println("\n: start\r\n" + ": exit\r\n" + ": help\r\n" + ": commands");
        System.out.print("\n$ ");
        command = input.nextLine();

    }

    private void exit(){ //command list method
        System.out.println("\nThank you for playing Nim");
        isRunning = false;
      
    }

    private void stars(NimPlayer currentPlayer){
        for (int i = 1; i <= currentPlayer.getTotalStones(); i++) {
            System.out.print("* ");
        }
    }

} //end of Nimsys class

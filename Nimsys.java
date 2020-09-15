import java.util.Scanner;

public class Nimsys {

    public static Scanner input = new Scanner(System.in); //scanner
    public static Nimsys gameObj = new Nimsys();//create main game object
    //public NimPlayer //p = new NimPlayer(null, 0,0,0); //an object to take the total number of games played.
    public static int turnRound; // count how many rounds played in each round
    private static String command = null; //take input into command line

    public static void main(String[] args) {  //this is the main method contains commands line console input

        System.out.print("Welcome to Nim\n");
        System.out.print("Please enter a command to continue\n$ ");
        command = input.nextLine().toLowerCase();

        do{
            System.out.println(" ");

            switch (command) {
                case "start":
                    gameObj.startGame();
                    break;
                case "help":
                    gameObj.help();
                    break;
                case "commands":
                    gameObj.commandList();
                    break;
                case "exit":
                    gameObj.exit();
                default:
                    command = input.next();
                    break;
            }
        }while(!command.equals(""));

    }

    private void startGame(){

        NimPlayer player_1 = new NimPlayer(null,0,0,0);
        NimPlayer player_2 = new NimPlayer(null,0,0,0);

        String p1, p2;

        while(command.equals("Y")){
            System.out.print("Please enter Player 1's name : ");

            p1 = input.nextLine();
            player_1.setName(p1);//player_1 enter name;

            System.out.print("Please enter Player 2's name : ");
            p2 = input.nextLine();
            player_2.setName(p2);//player_2 enter name;

            gameObj.newtGame(player_1, player_2); //done
            break;
        }
    }

    private void newtGame(NimPlayer player_1, NimPlayer player_2) {  //Start a new game.
        NimPlayer currentPlayer;

        do {
            String star = "* ";
            //new NimPlayer(null,0,0,0);
            currentPlayer = player_2;//object to handle who's turn，initialize to player_2
            System.out.print("Enter upper bound : ");
            int upperBound = input.nextInt();
            System.out.print("Enter initial number of stones : ");
            int totalStones = input.nextInt();

            do {
                if (currentPlayer.getName().equals(player_1.getName())) {
                    currentPlayer = player_2;
                } else if (currentPlayer.getName().equals(player_2.getName())) {
                    currentPlayer = player_1;
                }
                turnRound++;

                System.out.println(totalStones + " stones left : " + star.repeat(totalStones));
                System.out.println(currentPlayer.getName() + "'s turn. Enter stones to remove : ");
                currentPlayer.setStones(input.nextInt());

                currentPlayer.setNumOfGames(1);//count the turns

                while (currentPlayer.removeStone() <= 0 || currentPlayer.removeStone() > upperBound) {
                    //this is the loop to determine whether a legal selection is provided.

                    System.out.println("Upper bound limit exceed, upper bound maximum choice is "
                            + upperBound);
                    System.out.println(currentPlayer.getName() + "'s turn. Enter stones to remove : ");
                    currentPlayer.setStones(input.nextInt());
                }

                if (currentPlayer.removeStone() > totalStones) { //check if stone number lager than remaining
                    System.out.println("Invalid attempt, only " + totalStones + " stones remaining! Try again:");
                    currentPlayer.setStones(input.nextInt());
                }
                totalStones = totalStones - currentPlayer.removeStone();

            } while (totalStones > 0);

            currentPlayer.setNumOfGames(1);
            System.out.println("Game Over"); //round ends
            currentPlayer.setNumOfWins(0);

            if (turnRound % 2 != 0) {
                currentPlayer = player_2;
            } else {
                currentPlayer = player_1;
            }

            System.out.println(currentPlayer.getName() + " wins!\n");


        }while(input.nextLine().equals("Y"));

        System.out.println("Do you want to play again (Y/N): ");
        String playOrNot = input.nextLine().toUpperCase();

        if (playOrNot.toUpperCase().equals("Y")) {
            gameObj.newtGame(player_1, player_2);
        } else if (playOrNot.toUpperCase().equals("N")) {

            System.out.println(player_1.getName() + " won " + player_1.getWins() +" games out of " +
                    currentPlayer.getGamesCount() + " played");
            System.out.println(player_2.getName() + " won " + player_2.getWins() +" games out of " +
                    currentPlayer.getGamesCount() + " played");

            gameObj.exit();
        }
    }//end of new game


    private void help () {  //command list method
        System.out.println("Type commands to list all available commands");
        System.out.println("Type start to play game");
        System.out.println("Player to remove the last stone loses!");
        System.out.println("$ ");
        command = input.next();
    }

    private void commandList(){ //command list method

        System.out.println("\n: start\n" + ": exit\n" + ": help\n" + ": commands");
        System.out.print("\n$ ");
        command = input.next();

    }

    private void exit(){ //command list method
        System.out.println("Thank you for playing Nim");
        return;
    }

} //end of Nimsys class

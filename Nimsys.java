import java.util.Scanner;

public class Nimsys {

    public static Scanner input = new Scanner(System.in);
    public static int turnRound = 0; // count round played
    public String continuePlay = "Y";

    private boolean isRunning = true;

    public static void main(String[] args) {
        System.out.println("Welcome to Nim");
        System.out.println("\nPlease enter a command to continue\n");

        Nimsys gameObj = new Nimsys();
        gameObj.command(); //go to command
    }


    public void command() {
        String command;
        do {
            System.out.print("$ ");
            command = input.nextLine().toLowerCase();

            switch (command) {
                case "start":
                    startGame();
                    break;
                case "help":
                    help();
                    break;
                case "commands":
                    commandList();
                    break;
            }
        } while (!command.equals("exit"));
        exit();
    }


    public void startGame() {

        System.out.print("\nPlease enter Player 1's name : "); //player1 to input name
        String p1 = input.next();
        NimPlayer player_1 = new NimPlayer(p1, 0, 0, 0);

        System.out.print("Please enter Player 2's name : "); //player2 to input name
        String p2 = input.next();
        NimPlayer player_2 = new NimPlayer(p2, 0, 0, 0);

        //invoke the main game body of Nim
        newGame(player_1, player_2);

    }

    private void newGame(NimPlayer player_1, NimPlayer player_2) {

        do {

            System.out.print("Enter upper bound : ");
            int upperBound = input.nextInt();  //set upperbound
            System.out.print("Enter initial number of stones : ");
            int totalStones = input.nextInt(); //initial number of stones
            turnRound = 0;
            NimPlayer currentPlayer = player_1;   //init current player as player1



            do {    //decide turns of each player
                if (turnRound % 2 == 0) {
                    currentPlayer = player_1;
                } else {
                    currentPlayer = player_2;
                }
                System.out.print("\n" + totalStones + " stones left :");
                star(totalStones);
                System.out.print("\n" + currentPlayer.getName() + "'s turn. Enter stones to remove : ");
                currentPlayer.setStones(input.nextInt());//bug fixed for previous version
                int sn = currentPlayer.removeStone();

                while (currentPlayer.removeStone() <= 0 || currentPlayer.removeStone() > upperBound) {
                    System.out.println("Upper bound limit exceed, " +
                            "upper bound maximum choice is " + upperBound);
                    System.out.print("\n" + currentPlayer.getName() +
                            "'s turn. Enter stones to remove : ");
                    currentPlayer.setStones(input.nextInt());
                }

                while (currentPlayer.removeStone() > totalStones) {
                    System.out.print("Invalid attempt, only " + totalStones + " stones remaining! Try again: ");
                    currentPlayer.setStones(input.nextInt());
                }

                //minus the number of removed stone and print left stone if exist
                totalStones = totalStones - currentPlayer.removeStone();
                //System.out.print("\n" + totalStones + " stones left :");
                //star(totalStones);

                turnRound++; //count the turns

            }while (totalStones > 0);

                if (totalStones == 0) {
                    System.out.println("\nGame Over");  //round ends
                    if (currentPlayer.equals(player_1)) {
                        currentPlayer = player_2;
                    } else {
                        currentPlayer = player_1;
                    }
                    System.out.println(currentPlayer.getName() + " wins!");
                    currentPlayer.setNumOfWins(currentPlayer.getNumOfWins() + 1);

                    player_1.setGameCount(player_1.getGameCount() + 1);
                    player_2.setGameCount(player_2.getGameCount() + 1);
               }
            System.out.print("\nDo you want to play again (Y/N): ");
            input.nextLine().toUpperCase();

            if (input.nextLine().toUpperCase().equals("Y")) {
                isRunning = true;
            }else {
                isRunning = false;

            }

        }while(isRunning);

        int win1 = player_1.getNumOfWins();
        int win2 = player_2.getNumOfWins();

        System.out.printf( "%s won %x game%s out of %x played",
                player_1.getName(), player_1.getNumOfWins(),
                win1 > 1?"s":"", player_1.getGameCount());

        System.out.printf( "\n%s won %x game%s out of %x played\n",
                player_2.getName(), player_2.getNumOfWins(),
                win2 > 1?"s":"", player_2.getGameCount());
        exit();
    }

    private void commandList () {
        System.out.println("\n: start\r\n" +
                    ": exit\r\n" + ": help\r\n" + ": commands");
    }

    //command methods:
    private void help () {
        System.out.println("Type commands to list all available commands");
        System.out.println("Type start to play game");
        System.out.println("Player to remove the last stone loses!");
        System.out.println();

    }

    private void exit () {
        System.out.println("$");
        System.out.println("\nThank you for playing Nim\n");
        //isRunning = false;
    }

    private void star ( int totalStones){
        for (int i = 0; i < totalStones; i++) {
            System.out.print(" *");
        }
    }

}//end of Ninsys Class

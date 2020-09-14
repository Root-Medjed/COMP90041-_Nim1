import java.util.*;

public class Nimsys {

    public static Scanner input = new Scanner(System.in); //scanner
    public static Nimsys gameObj = new Nimsys();//create main game object
    public static int ifContinue = 0;

    private int upperBound = 0;
    private int totalStones = 0;
    private int totalRound = 0;
    private NimPlayer player_1 = null;
    private NimPlayer player_2 = null;
    private String currentPlayer =null;


    public static void main(String[] args) {

        //Nimsys gameObj = new Nimsys();
        String command; //take input into command line

        System.out.print("Welcome to Nim\n");
        System.out.print("Please enter a command to continue\n$ ");
        command = input.nextLine().toLowerCase();

        while(ifContinue == 0) {
            System.out.print("$ ");
            if (command.toLowerCase().equals("start")) {
                gameObj.startGame();
            }
            else if (command.toLowerCase().equals("help")) {
                gameObj.help();
            }
            else if (command.toLowerCase().equals("commands")) {
                gameObj.commandList();
            }
            else if(command.toLowerCase().equals("exit")){
                gameObj.exit();
            }
            else {
                command = input.nextLine();
            }
        }

    }
    public void startGame(){
        player_1 = new NimPlayer();
        player_2 = new NimPlayer();

        System.out.print("Please enter Player 1's name : ");
        player_1.setName(input.nextLine());//p1 enter name;

        System.out.print("Please enter Player 2's name : ");
        player_2.setName(input.nextLine());//p2 enter name;

        gameObj.newtGame();

    }

    public void newtGame() {  //Start a new game.
        String star = "* ";
        currentPlayer = player_1.getName();
        NimPlayer sn = new NimPlayer(); //object stone

        System.out.print("Enter upper bound : ");
        upperBound = input.nextInt();
        System.out.print("Enter initial number of stones : ");
        totalStones = input.nextInt();

        while (totalStones > 0){
            totalRound += 1;
            System.out.println(totalStones + " stones left : " + star.repeat(totalStones));
            System.out.println(currentPlayer + "'s turn. Enter stones to remove : ");
            sn.setStones(input.nextInt());

            while (sn.removeStone() <= 0 || sn.removeStone() >= 4) {
                System.out.println("Upper bound limit exceed, upper bound maximum choice is "
                        + upperBound);
                System.out.println(currentPlayer + "'s turn. Enter stones to remove : ");
                sn.setStones(input.nextInt());
            }

            while (sn.removeStone() > totalStones){ //if stone number lager than remaining
                System.out.println("Invalid attempt, only " +  totalStones + " stones remaining! Try again:" );
                sn.setStones(input.nextInt());
            }
            totalStones = totalStones - sn.removeStone();

        } System.out.println("Game Over");
        totalRound -= 1;
        System.out.println(currentPlayer + " wins!\n");
        //.setNumOfWins(1);
        System.out.println("Do you want to play again (Y/N): ");
        String playAgain = input.nextLine().toUpperCase();
        if(playAgain.equals("Y")){
            gameObj.newtGame();
        }else if(playAgain.toUpperCase().equals("N")){
            gameObj.exit();
        }


        if (totalRound % 2 == 0) {
            currentPlayer = player_2.getName();
        } else if(totalRound % 2 != 0){
            currentPlayer = player_1.getName();
        }
    }

    private void help () {  //command list method
        System.out.println("Type commands to list all available commands");
        System.out.println("Type start to play game");
        System.out.println("Player to remove the last stone loses!");
        }

    private void commandList(){ //command list method

        System.out.println(": start\n" + ": exit\n" + ": help\n" + ": commands");

    }

    private void exit(){ //command list method
        System.out.println("Thank you for playing Nim");
    }

}


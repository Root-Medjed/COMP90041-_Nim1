import java.util.*;

public class Nimsys {

    static Scanner userInput;// scanner to take user input


    public static void main(String[] args) { //main method here

        System.out.print("Welcome to Nim");

        System.out.println("Please enter a command to continue\n$ ");

        System.out.println("Type 'start' to start the game: ");

        String command = userInput.nextLine();

        //create command-line input console:
        switch(command){
            case "start":
            Nimsys.startGame();
            break;

            case "exit":
            System.out.println("Thanks you for playing Nim");
            break;

            case "help":
            Nimsys helpMe = new Nimsys();
            helpMe.help();
            break;

            case "commands":
            Nimsys commandLine = new Nimsys();
            commandLine.commandList();
            break;

            default:
                if (command == "") command = "exit";
                break;

        }

    }


    public void help(){
        System.out.println("Type commands to list all available commands\n" +
                "Type start to play game\n" +
                "Player to remove the last stone loses!");
    }

    public void commandList(){
        System.out.println(": start\n" + ": exit\n" + ": help\n" + ": commands");
    }

    public static void startGame(){ //this is the main game;
        String star = "*";
        NimPlayer stone = new NimPlayer();

        System.out.print("Please enter Player 1's name : ");//done
        NimPlayer p1 = new NimPlayer();
        p1.setName_p1(userInput.nextLine()); //done

        System.out.print("Please enter Player 2's name : ");//done
        NimPlayer p2 = new NimPlayer();
        p2.setName_p2(userInput.nextLine());//done

        System.out.print("Enter upper bound : ");
        int upperBound = userInput.nextInt();

        System.out.print("Enter initial number of stones : ");
        stone.setStone(userInput.nextInt());

        if (stone.getStone() > 0) {
            System.out.println(stone.getStone() + "stones left : " + star.repeat(stone.getStone()));
            System.out.print(p1.getName_p1() + "'s turn. Enter stones to remove : ");
            stone.setStoneToMove(userInput.nextInt());
        }
        else {
            System.out.println("Game Over");
            System.out.println("wins!");
        }
    }

}

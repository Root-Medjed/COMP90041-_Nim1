public class NimPlayer
{
    private String name;    //player's name
    private int wins;     //how many wins
    private int gamePlayed;    //how many games
    private int stones; //set the num of stone player wants to move each turn

    //public NimPlayer()

    public NimPlayer(String name, int wins, int gamePlayed, int stones){
        this.name = name;
        this.wins = wins;
        this.gamePlayed = gamePlayed;
        this.stones = stones;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfWins() {//getters to get the number of wins
        return wins;
    }

    public void setNumOfWins(int wins) { //count wins
        this.wins = wins;
    }

    public int getGameCount() {
        return gamePlayed;
    }

    public void setGameCount(int gamePlayed) {
        this.gamePlayed = gamePlayed;
    }


    public int removeStone() {  //getters to get player inputs - stone to remove
        return stones;
    }

    public void setStones(int stones){  //setters to set the stone to remove each turn
        this.stones = stones;
    }

}

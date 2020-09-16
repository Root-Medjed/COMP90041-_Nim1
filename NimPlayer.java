public class NimPlayer {
    private String name;
    private int stones; //the number of stones the player wants to remove in his/her turn.
    private int wins; //how many wins;
    private int gamesCount; //how many games played;

    public NimPlayer(String name, int wins, int gamesCount, int stones){ //constructor & other
        this.name = name;
        this.stones = stones;
        this.wins = wins;
        this.gamesCount = gamesCount;
    }

    //public NimPlayer(){
        //this.name = null;
        //this.stones = 0;
        //this.wins = 0;
    //}

    public void setName(String name){

        this.name = name;
    }

    public String getName(){

        return name;
    }

    public void setStones(int stones){

        this.stones = stones;  //num came from the input
    }

    public int removeStone(){ //get stone
        return stones;
    }

    public void setNumOfWins(int wins){ //set the number of wins

        this.wins = wins;
    }

    public int getWins(){

        return wins;
    }

    public int getGamesCount(){

        return gamesCount;
    }

    public void setNumOfGames(int gamesCount) {

        this.gamesCount = gamesCount;
    }

}


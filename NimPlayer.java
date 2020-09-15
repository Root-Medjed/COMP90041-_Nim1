public class NimPlayer {
    private String name;
    private Integer stones; //the number of stones the player wants to remove in his/her turn.
    private Integer wins; //how many wins;
    private Integer gamesCount; //how many games played;
    private Integer s;

    public NimPlayer(String name, int wins, int gamesCount, int stones, int s){ //constructor & other
        this.name = name;
        this.stones = stones;
        this.wins = wins;
        this.gamesCount = gamesCount;
        this.s = s;
    }

    //public NimPlayer()


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

        this.wins += wins;
    }

    public int getWins(){

        return wins;
    }

    public int getGamesCount(){

        return gamesCount;
    }

    public void setNumOfGames(int gamesCount) {

        this.gamesCount += gamesCount;
    }

    public void setTotalStone(int s){ //set total number of stones left
        this.s = s;
    }

    public int getTotalStones() //get total number of stones left
    {
        return s;
    }
    
}

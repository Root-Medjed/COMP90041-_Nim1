public class NimPlayer {

    private String name;
    private int stones; //the number of stones the player wants to remove in his/her turn.
    private int wins = 0; //how many wins;
    private int gamesCount = 0; //how many games played;
    //private int totalRound = 0; // count how many rounds played in each round

    public NimPlayer(String name, int wins, int gamesCount）//int totalRound){ //constructor & other
        this.name = name;
        //this.totalRound = totalRound;
        this.wins = wins;
        this.gamesCount = gamesCount;
    }

    public NimPlayer(){

    }

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

    //public static void getWins(){
    //System.out.println();
    //}

    public void setNumOfGames(int gamesCount){ //static method to count the number of games =
        this.gamesCount += gamesCount;
    }

    public int getGamesCount(){
        return gamesCount;
    }

    public int getTotalRound() {
        return totalRound;
    }

    //public void setTotalRound(int totalRound) {
        //this.totalRound += totalRound;
    //}

    public void setNumOfWins(int wins){ //set the number of wins
        this.wins = wins;
    }
    
    public int getWins(){
        return wins;
    }

    public void setNumOfGames(int gamesCount){ //static method to count the number of games =
        this.gamesCount = gamesCount;
    }
    
    public int getGamesCount(){
        return gamesCount;
    }

}

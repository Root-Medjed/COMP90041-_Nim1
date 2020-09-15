public class NimPlayer {

    public NimPlayer(){

    }
    
    private String name;
    private Integer stones; //the number of stones the player wants to remove in his/her turn.
    private Integer wins = 0; //how many wins;
    private Integer gamesCount = 0; //how many games played;
    
//constructor & other
    
    public NimPlayer(String name, int wins, int games, int stones){ 
        this.name = name;
        this.stones = stones;
        this.wins = wins;
    }


    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    
//num came from the input
    
    public void setStones(int stones){
        this.stones = stones;  
    }
    
//get stone
    
    public int removeStone(){ 
        return stones;
    }
    
//set the number of wins
    public void setNumOfWins(int wins){ 
        this.wins += wins;
    }

    public int getWins(){
        return wins;
    }
    
//count the number of games played in total (setter)
    public void setGamesCount(int games) {
        this.gamesCount += gamesCount;
    }

    public int getGamesCount(){
        return gamesCount;
    }
}

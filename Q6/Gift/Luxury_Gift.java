package Q3.Gift;


public class Luxury_Gift extends Gift {
    
    private int luxuryRating;
    private int difficulty;
    
    public Luxury_Gift(int Price, int Value, int Luxury, int Difficulty){
        super(Price, Value);
        this.luxuryRating = Luxury;
        this.difficulty = Difficulty;
    }
    
    public int getLuxuryRating(){
        return this.luxuryRating;
    }
    
    public int getDifficulty(){
        return this.difficulty;
    }
}

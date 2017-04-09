package Q3.GIrl;

import Q3.Boy.Boy;
import Q3.Gift.Gift;
import java.util.ArrayList;


abstract public class Girl {
    private String name;
    private int attractiveness;
    private int maintenance;
    private int intelligence;
    private int criterion;
    protected ArrayList<Gift> gifts = new ArrayList<Gift>();
    
    Girl(String Name, int Attractive, int Maintenance, int Intelli, int Criterion){
        this.name = Name;
        this.attractiveness = Attractive;
        this.maintenance =  Maintenance;
        this.intelligence = Intelli;
        this.criterion = Criterion;
    }
    
    public ArrayList<Gift> getGifts(){
        return this.gifts;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAttractiveness(){
        return this.attractiveness;
    }
    
    public int getMaintenance(){
        return this.maintenance;
    }
    
    public int getIntelligence(){
        return this.intelligence;
    }
    
    abstract public void recieveGift(Gift x);
    abstract public float getHappiness();
    
    public Boy selectBF(ArrayList<Boy> boys){
        
        Boy max = boys.get(0);
        int i , n = boys.size();
        for(i=0;i<n;i++){
            
            if(boys.get(i).isCommitted()){
                
                continue;
            }
            
            if(this.criterion == 0 && boys.get(i).getAttractiveness() > max.getAttractiveness())
                max = boys.get(i);
            
            else if(this.criterion == 1 && boys.get(i).getBudget() > max.getBudget())
                max = boys.get(i);
            
            else if(this.criterion == 2 && boys.get(i).getIntelligence() > max.getIntelligence())
                max = boys.get(i);
        }
        
        if(max.getMinAttraction() > this.attractiveness || max.getBudget() < this.maintenance)
            return null;
        
        else if(max == boys.get(0) && max.isCommitted())
            return null;
        
        else return max;
    }
}
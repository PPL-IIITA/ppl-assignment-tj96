package Classes;


import java.util.ArrayList;


public class Girl {
    private String name;
    private int attractiveness;
    private int maintenance;
    private int intelligence;
    private int criterion;
    private int type;
    
    /**
    * type = 0 for choosy girls,
    * type = 1 for normal girls,
    * type = 2 for desperate girls.
    * <p>
    * Criterion = 0 for most Attractive guy
    * Criterion = 1 for Richest Guy
    * Criterion = 2 for most Intelligent guy
     
    * @param Name
    * @param Attractive
    * @param Maintenance
    * @param Intelli
    * @param Criterion
    * @param Type 
    */
    public Girl(String Name, int Attractive, int Maintenance, int Intelli, int Criterion, int Type){
        this.name = Name;
        this.attractiveness = Attractive;
        this.maintenance =  Maintenance;
        this.intelligence = Intelli;
        this.criterion = Criterion;
        this.type = Type;
        this.totalCost = -1 * this.maintenance;
    }
    /**
     * 
     * @return 
     */
    public String getName(){
        return this.name;
    }
    /**
     * 
     * @return 
     */
    public int getAttractiveness(){
        return this.attractiveness;
    }
    /**
     * 
     * @return 
     */
    public int getMaintenance(){
        return this.maintenance;
    }
    /**
     * 
     * @return 
     */
    public int getIntelligence(){
        return this.intelligence;
    }
    
    private int totalCost;
    
    /**
     * Function used for recieving gift
     * @param x 
     */
    public void recieveGift(Gift x){
        
        this.totalCost += x.getPrice();
        
        if(this.type == 0 && x.getType() == 1)
            this.totalCost += x.getPrice();
        
        if(this.type == 1)
            this.totalCost += x.getValue();
    }
    
    /**
     * 
     * @return 
     */
    public float getHappiness(){
        if(totalCost <= 0)return 0;
        else {
            if(this.type == 0)
                return (float)Math.log(totalCost + 1);
            if(this.type == 1)
                return this.totalCost;
            if(this.type == 2)
                return (float)Math.pow(this.totalCost , 2);
        }
        return -1;
    }
    
    /**
     * function to find boyfriend
     * @param boys
     * @return 
     */
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

package Classes;


import java.util.ArrayList;


public class Boy {
    private String name;
    private int attractiveness;
    private int budget;
    private int intelligence;
    private int minAttReq;
    private int type;
    private int moneySpent = 0;
    private Girl girlfriend = null;
    
    /**
     * Type = 0 for Miser Boy
     * Type = 1 for Generous Boy
     * Type = 2 for Geek Boy
     * 
     * @param Name
     * @param Attractive
     * @param Budget
     * @param Intelli
     * @param min for Minimum Attractive
     * @param Type 
     */
    public Boy(String Name, int Attractive, int Budget, int Intelli, int min, int Type){
        this.name = Name;
        this.attractiveness = Attractive;
        this.budget =  Budget;
        this.intelligence = Intelli;
        this.minAttReq = min;
        this.type = Type;
    }
    
    /**
     * To check if this Boy is committed
     * @return 
     */
    boolean isCommitted(){
        if(this.girlfriend == null)return false;
        else return true;
    }
    /**
     * 
     * @param gf 
     */
    public void setGirlfriend(Girl gf){
        this.girlfriend = gf;
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
    public int getBudget(){
        return this.budget;
    }
    /**
     * 
     * @return 
     */
    public int getIntelligence(){
        return this.intelligence;
    }
    /**
     * 
     * @return 
     */
    public int getMinAttraction(){
        return this.minAttReq;
    }
    /**
     * 
     * @param amount 
     */
    protected void increaseBudget(int amount){
        this.budget += amount;
    }
    
    /**
     * to give gifts to girlfriend
     * @param list
     * @return 
     */
    public ArrayList<Gift> giveGifts(ArrayList<Gift> list){
        
        if(this.girlfriend == null)
            return null;
        
        int i , count=0 , n=list.size() , totalCost=0 ;
        int budget = this.getBudget();
        ArrayList<Gift> giftsgiven = new ArrayList<Gift>();
        
        if(budget < list.get(0).getPrice())
            this.increaseBudget(list.get(0).getPrice() - budget + 1);
        
        for(i=0 ; i<n ; i++){
            
            if( totalCost + list.get(i).getPrice() > budget )
                break;
            
            this.girlfriend.recieveGift(list.get(i));
            giftsgiven.add(list.get(i));
            totalCost += list.get(i).getPrice();
            
            if((this.type == 0 || this.type == 2) && totalCost >= this.girlfriend.getMaintenance())
                break;
        }
        
        if(this.type == 2){
            for(; i<n; i++)
                if(list.get(i).getType() == 1){
                    if( totalCost + list.get(i).getPrice() > budget )
                        break;
            
                    this.girlfriend.recieveGift(list.get(i));
                    giftsgiven.add(list.get(i));
                    totalCost += list.get(i).getPrice();
                }
        }
        
        this.moneySpent = totalCost;
        return giftsgiven;
    }
    
    /**
     * 
     * @return 
     */
    public float getHappiness(){
        if(this.type == 0)
            return this.getBudget() - this.moneySpent;
        if(this.girlfriend == null)
            return 0;
        if(this.type == 1)
            return this.girlfriend.getHappiness();
        if(this.type == 2)
            return this.girlfriend.getIntelligence();
        
        return -1;
    }
}

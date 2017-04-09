package Q3.GIrl;

import Q3.Gift.Gift;

public class NormalGirl extends Girl{
    
    private int totalCost;
    
    public NormalGirl(String Name, int Attractive, int Maintenance, int Intelli, int Criterion){
        super(Name, Attractive, Maintenance, Intelli, Criterion);
        this.totalCost = -1 * Maintenance;
    }
    
    @Override
    public void recieveGift(Gift x){  
        this.totalCost += x.getPrice() + x.getValue();
        this.gifts.add(x);
    }
    
    @Override
    public float getHappiness(){
        if(totalCost <= 0)return 0;
        else {
            return this.totalCost;
        }
    }
    
}


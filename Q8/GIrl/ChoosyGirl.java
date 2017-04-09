package Q3.GIrl;

import Q3.Boy.Boy;
import Q3.Gift.Gift;
import Q3.Gift.Luxury_Gift;

public class ChoosyGirl extends Girl{
    
    private int totalCost;
    
    public ChoosyGirl(String Name, int Attractive, int Maintenance, int Intelli, int Criterion){
        super(Name, Attractive, Maintenance, Intelli, Criterion);
        this.totalCost = -1 * Maintenance;
    }
    
    @Override
    public void recieveGift(Gift x){
        
        this.totalCost += x.getPrice();
        this.gifts.add(x);
        
        if(x instanceof Luxury_Gift)
            this.totalCost += x.getPrice();
    }
    
    @Override
    public float getHappiness(){
        if(totalCost <= 0)return 0;
        else {
            return (float)Math.log(totalCost + 1);
        }
    }
    
    
}

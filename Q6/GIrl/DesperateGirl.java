package Q3.GIrl;

import Q3.Gift.Gift;

public class DesperateGirl extends Girl{
    
    private int totalCost;
    
    public DesperateGirl(String Name, int Attractive, int Maintenance, int Intelli, int Criterion){
        super(Name, Attractive, Maintenance, Intelli, Criterion);
        this.totalCost = -1 * Maintenance;
    }
    
    @Override
    public void recieveGift(Gift x){    
        this.totalCost += x.getPrice();
        this.gifts.add(x);
    }
    
    @Override
    public float getHappiness(){
        if(totalCost <= 0)return 0;
        else {
            return (float)Math.pow(this.totalCost , 2);
        }
    }
    
}

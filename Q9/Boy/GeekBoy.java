package Q3.Boy;

import Q3.Gift.Gift;
import java.util.ArrayList;

public class GeekBoy extends Boy {
        
    public GeekBoy(String Name, int Attractive, int Budget, int Intelli, int min){
        super(Name, Attractive, Budget, Intelli, min);
    }
    
    // Make sure the gift list is sorted.
    @Override
    public void giveGifts(ArrayList<Gift> list){
                
        int i , count=0 , n=list.size() , totalCost=0 ;
        int budget = this.getBudget();
        
        if(budget < list.get(0).getPrice())
            this.increaseBudget(list.get(0).getPrice() - budget + 1);
        
        for(i=0 ; i<n ; i++){
            
            if( totalCost + list.get(i).getPrice() > budget )
                break;
            
            this.girlfriend.recieveGift(list.get(i));
            totalCost += list.get(i).getPrice();
            
            if(totalCost >= this.girlfriend.getMaintenance())
                break;
        }
        
    }
    
    @Override
    public float getHappiness(){
        if(this.girlfriend == null)return 0;
        return this.girlfriend.getIntelligence();
    }
}

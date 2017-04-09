




import Q1_2.Boy;
import Q1_2.Gift;
import Q1_2.Girl;
import java.util.ArrayList;


public class Couple {
    
    private Girl girlFriend;
    private Boy boyFriend;
    public ArrayList<Gift> giftsExchanged = new ArrayList<Gift>();
    
    /**
     * 
     * @param gf
     * @param bf 
     */
    public Couple(Girl gf, Boy bf){
        this.boyFriend = bf;
        this.girlFriend = gf;
        bf.setGirlfriend(gf);
    }
    
    /**
     * To exchange gifts between girlfriend and boyfriend
     * @param list 
     */
    public void exchangeGifts(ArrayList<Gift> list){
        this.boyFriend.giveGifts(list);
    }
    /**
     * 
     * @return 
     */
    public Girl getGF(){
        return this.girlFriend;
    }
    /**
     * 
     * @return 
     */
    public Boy getBf(){
        return this.boyFriend;
    }
    /**
     * 
     * @return 
     */
    public float getHappiness(){
        return this.girlFriend.getHappiness() +
                this.boyFriend.getHappiness();
    }
    /**
     * 
     * @return 
     */
    public float getCompatibility(){
        int x = boyFriend.getBudget() - girlFriend.getMaintenance();
        x += Math.abs(boyFriend.getAttractiveness() - girlFriend.getAttractiveness());
        x += Math.abs(boyFriend.getIntelligence() - girlFriend.getIntelligence());
        
        return x;
    }
    
}

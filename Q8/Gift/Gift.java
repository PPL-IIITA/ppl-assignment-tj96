package Q3.Gift;

abstract public class Gift {
    
    private int price;
    private int value;
    
    Gift(int Price, int Value){
        this.price = Price;
        this.value = Value;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public int getValue(){
        return this.value;
    }
    
    /**
     * provide printable information of Gift
     * @return 
     */
    
}

package Classes;


public class Gift {
    private int price;
    private int value;
    private int type;
    private int luxuryRating = 0;
    private int difficulty = 0;
    private int utilityValue = 0;
    private int utilityClass = 0;
    
    public Gift(int Price, int Value, int Type){
        this.price = Price;
        this.value = Value;
        this.type = Type;
    }
    
    /**
     *  if type=1
            Variable 'a' has value for luxuryRating
            Variable 'b' has value for difficulty
        if type=2
            Variable 'a' has value for utilityValue
            Variable 'b' has value for utilityClass
     * @param Price
     * @param Value
     * @param Type
     * @param a
     * @param b 
     */
    public Gift(int Price, int Value, int Type, int a, int b){
        this.price = Price;
        this.value = Value;
        this.type = Type;
        if(Type == 1){
            this.luxuryRating = a;
            this.difficulty = b;
        }
        else if(Type == 2){
            this.utilityValue = a;
            this.utilityClass = b;
        }
    }
    
    /**
     * provide printable information of Gift
     * @return 
     */
    public String toString(){
        String str = "";
        if(this.type == 0)
            str += this.price +" "+ this.value;
        else if(this.type == 1)
            str += this.price +" "+ this.value +" "+ this.luxuryRating +" "+ this.difficulty;
        else if(this.type == 2)
            str += this.price +" "+ this.value +" "+ this.utilityValue +" "+ this.utilityClass;
        return str;        
    }
    /**
     * 
     * @return 
     */
    public int getType(){
        return this.type;
    }
    /**
     * 
     * @return 
     */
    public int getPrice(){
        return this.price;
    }
    /**
     * 
     * @return 
     */
    public int getValue(){
        return this.value;
    }
    /**
     * 
     * @return 
     */
    public int getLuxuryRating(){
        return this.luxuryRating;
    }
    /**
     * 
     * @return 
     */
    public int getDifficulty(){
        return this.difficulty;
    }
    /**
     * 
     * @return 
     */
    public int getUtilityValue(){
        return this.utilityValue;
    }
    /**
     * 
     * @return 
     */
    public int getUtilityClass(){
        return this.utilityClass;
    }
}

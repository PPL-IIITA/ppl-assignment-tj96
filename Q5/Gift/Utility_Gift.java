package Q3.Gift;

public class Utility_Gift extends Gift {
    
    private int utilityValue;
    private int utilityClass;
    
    public Utility_Gift(int Price, int Value, int UtilityValue, int UtilityClass){
        super(Price, Value);
        this.utilityValue = UtilityValue;
        this.utilityClass = UtilityClass;
    }
    
    public int getUtilityValue(){
        return this.utilityValue;
    }
    
    public int getUtilityClass(){
        return this.utilityClass;
    }
}

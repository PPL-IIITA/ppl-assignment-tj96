package Q3.Boy;

import Q3.Gift.Gift;
import Q3.GIrl.Girl;
import java.util.ArrayList;
import java.util.Scanner;


abstract public class Boy {
    private String name;
    private int attractiveness;
    private int budget;
    private int intelligence;
    private int minAttReq;
    protected Girl girlfriend = null;
    
    Boy(String Name, int Attractive, int Budget, int Intelli, int min){
        this.name = Name;
        this.attractiveness = Attractive;
        this.budget =  Budget;
        this.intelligence = Intelli;
        this.minAttReq = min;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getAttractiveness(){
        return this.attractiveness;
    }
    
    public int getBudget(){
        return this.budget;
    }
    
    public int getIntelligence(){
        return this.intelligence;
    }
    
    public int getMinAttraction(){
        return this.minAttReq;
    }
    
    abstract public void giveGifts(ArrayList<Gift> y);
    abstract public float getHappiness();
    
    protected void increaseBudget(int amount){
        this.budget += amount;
    }
    
    public boolean isCommitted(){
        if(this.girlfriend == null)return false;
        else return true;
    }
    
    public void setGirlfriend(Girl gf){
        this.girlfriend = gf;
    }
}


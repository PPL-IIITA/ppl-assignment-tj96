
import Q3.Gift.Utility_Gift;
import Q3.Gift.Essential_Gift;
import Q3.Gift.Gift;
import Q3.Gift.Luxury_Gift;
import Q3.Boy.GeekBoy;
import Q3.Boy.GenerousBoy;
import Q3.Boy.MiserBoy;
import Q3.Boy.Boy;
import Q3.GIrl.DesperateGirl;
import Q3.GIrl.Girl;
import Q3.GIrl.ChoosyGirl;
import Q3.GIrl.NormalGirl;
import java.util.ArrayList;
import Q1_2.Input;
import java.io.FileWriter;
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tushar
 */
public class Q4 {
    
    public static void main(String args[]){
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        FileWriter fw=null;
        try
        {
            fw = new FileWriter(dir+"/log",true);
            
            fw.write("New Instance\n");
        }
        catch(Exception ioe){}
        
        
        ArrayList boys = new ArrayList<Boy>();
        ArrayList girls = new ArrayList<Girl>();
        ArrayList<Couple> couples = new ArrayList<Couple>();
        ArrayList<Gift> gifts = new ArrayList<Gift>();
        
        
        Input input = new Input(dir+"/gifts");
        while(input.hasNext()){
            int Price = input.nextInt();
            int Value = input.nextInt();
            int Type = input.nextInt();
            if(Type == 0)
                gifts.add(new Essential_Gift(Price, Value));
            else if(Type == 1 || Type == 2){    
                int a = input.nextInt();
                int b = input.nextInt();
                if (Type == 1)gifts.add(new Luxury_Gift(Price, Value, a, b));
                else gifts.add(new Utility_Gift(Price, Value, a, b));
            }
        }
        input.close();
        
        input = new Input(dir+"/boys");
        while(input.hasNext()){
            String Name = input.next();
            int Attractive = input.nextInt();
            int Budget = input.nextInt();
            int Intelli = input.nextInt();
            int Min = input.nextInt();
            int Type = input.nextInt();
            if (Type == 0)
                boys.add(new MiserBoy(Name, Attractive, Budget, Intelli, Min));
            else if(Type == 1)
                boys.add(new GenerousBoy(Name, Attractive, Budget, Intelli, Min));
            else if(Type == 2)
                boys.add(new GeekBoy(Name, Attractive, Budget, Intelli, Min));
        }
        input.close();
        
        input = new Input(dir+"/girls");
        while(input.hasNext()){
            String Name = input.next();
            int Attractive = input.nextInt();
            int Maintenance = input.nextInt();
            int Intelli = input.nextInt();
            int Criterion = input.nextInt();
            int Type = input.nextInt();
            
            Girl g = null;
            if(Type == 0)
                g = new ChoosyGirl(Name, Attractive, Maintenance, Intelli, Criterion);
            else if(Type == 1)
                g = new NormalGirl(Name, Attractive, Maintenance, Intelli, Criterion);
            else if(Type == 2)
                g = new DesperateGirl(Name, Attractive, Maintenance, Intelli, Criterion);
            girls.add(g);
            
            Boy b = g.selectBF(boys);
            if(b != null){
                couples.add(new Couple(g,b));
                Date date = new Date();
                try {
                    fw.write(date+"   -   Couple formed between "+g.getName()+" and "+b.getName()+'\n');
                } catch (Exception ex) {
                    
                }
            }
        }
        input.close();
        
        int j,i,n = couples.size();
        for(i=0;i<n;i++){
            
            Couple c = couples.get(i);
            c.exchangeGifts(gifts);
            
            System.out.println("These gifts got exchanges b/w "+c.getGF().getName()+" and "+c.getBf().getName());
            ArrayList<Gift> list = couples.get(i).getGF().getGifts();
            int m = list.size();
            for(j=0;j<m;j++){
                System.out.println(list.get(j).toString());
            }
            
            Date date = new Date();
            try {
                fw.write(date+"   -   Gifts exchanged between "+c.getGF().getName()+" and "+c.getBf().getName()+"\n");
            } catch (Exception ex) {
                
            }
        }
        
        input = new Input(dir+"/k-value");
        int k = input.nextInt();
        
        input.close();
        
        for(i=0;i<n;i++){
            Couple x = couples.get(i);
            for(j=i;j<n;j++){
                Couple y = couples.get(j);
                if(x.getHappiness() < y.getHappiness()){
                    Couple tmp = couples.get(i);
                    couples.add(i, y);
                    couples.add(j, tmp);
                }
            }
        }
        System.out.println("k Most happiest couples are:");
        for(i=0;i<k && i<n;i++){
            System.out.println(couples.get(i).getBf().getName()+" <3 "+couples.get(i).getGF().getName());
        }
        
        
        for(i=0;i<n;i++){
            Couple x = couples.get(i);
            for(j=i;j<n;j++){
                Couple y = couples.get(j);
                if(x.getCompatibility() < y.getCompatibility()){
                    Couple tmp = couples.get(i);
                    couples.add(i, y);
                    couples.add(j, tmp);
                }
            }
        }
        System.out.println("k Most Compatible couples are:");
        for(i=0;i<k && i<n;i++){
            System.out.println(couples.get(i).getBf().getName()+" <3 "+couples.get(i).getGF().getName());
        }
        
        try {
            fw.write("\n");
            fw.close();
        } catch (Exception ex) {
            
        }
    }
    
    
}

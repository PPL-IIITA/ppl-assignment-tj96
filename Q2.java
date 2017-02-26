
import Classes.Input;
import Classes.Boy;
import Classes.Gift;
import Classes.Couple;
import Classes.Girl;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Q2 {
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
                gifts.add(new Gift(Price, Value, Type));
            else if(Type == 1 || Type == 2){    
                int a = input.nextInt();
                int b = input.nextInt();
                gifts.add(new Gift(Price, Value, Type, a, b));
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
            boys.add(new Boy(Name, Attractive, Budget, Intelli, Min, Type));
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
            
            Girl g = new Girl(Name, Attractive, Maintenance, Intelli, Criterion, Type);
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
            ArrayList<Gift> list = couples.get(i).giftsExchanged;
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
        
        System.out.println("Enter k");
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        
        
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
        System.out.println(k+" Most happiest couples are:");
        for(i=0;i<k && i<n;i++){
            System.out.println(couples.get(i).getBf().getName()+" and "+couples.get(i).getGF().getName());
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
        System.out.println(k+" Most Compatible couples are:");
        for(i=0;i<k && i<n;i++){
            System.out.println(couples.get(i).getBf().getName()+" and "+couples.get(i).getGF().getName());
        }
        
        try {
            fw.write("\n");
            fw.close();
        } catch (Exception ex) {
            
        }
    }
}

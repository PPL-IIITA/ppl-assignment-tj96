
import Classes.Input;
import Classes.Boy;
import Classes.Couple;
import Classes.Girl;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;


public class Q1 {
    public static void main(String args[]){
        
        String dir = System.getProperty("user.dir");
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
        
        
        Input input = new Input(dir+"/boys");
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
        
        
        int i,n = couples.size();
        for(i=0;i<n;i++){
            System.out.println(couples.get(i).getBf().getName()+" <3 "+couples.get(i).getGF().getName());
        }
        
        
        
        try {
            fw.write("\n");
            fw.close();
        } catch (Exception ex) {
            
        }
    }
}

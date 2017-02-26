package Classes;


import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Input {
    
    private Scanner scanner = null;
    
    public Input(String filePath){
        FileInputStream in = null;
        try {
            in = new FileInputStream(filePath);
        } catch (Exception ex) {
            //System.out.println(ex);
        }
        InputStreamReader isr = new InputStreamReader(in);
        this.scanner = new Scanner(isr);
    }
    
    public int nextInt(){
        return this.scanner.nextInt();
    }
    
    public long nextLong(){
        return this.scanner.nextLong();
    }
    
    public String next(){
        return this.scanner.next();
    }
    
    public String nextLine(){
        return this.scanner.nextLine();
    }
    
    public Double nextDouble(){
        return this.scanner.nextDouble();
    }
    
    public boolean hasNext(){
        return this.scanner.hasNext();
    }
    
    public void close(){
        this.scanner.close();
    }
    
}



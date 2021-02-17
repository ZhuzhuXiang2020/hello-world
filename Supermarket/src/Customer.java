import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Customer {
    private int itemsNum;

    public Customer(int itemsNum){
        this.itemsNum = itemsNum;
    }

    public Customer(){
        //customer carry random num of items
        Random random = new Random();
        this.itemsNum = random.nextInt(50);
    }

    public Customer(boolean input)  {
        if(input){
            System.out.println("Pleas enter how many items do you have?");
            Scanner scanner=new Scanner(System.in) ;

            while(scanner.hasNext()){
                try{
                    this.itemsNum = scanner.nextInt();
                    break;
                }catch(Exception e){
                    System.out.println("Please enter a valid number.");
                    scanner.next();
                }
            }
            scanner.close();
        }else{
            //customer carry random num of items
            Random random = new Random();
            this.itemsNum = random.nextInt(50);
        }
    }

    public int getItemsNum(){
        return this.itemsNum;
    }
}

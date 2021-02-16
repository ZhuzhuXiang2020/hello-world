import java.util.Random;

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

    public int getItemsNum(){
        return this.itemsNum;
    }
}

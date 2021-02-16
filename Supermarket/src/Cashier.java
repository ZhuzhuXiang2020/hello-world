import java.util.ArrayList;
import java.util.Random;

public class Cashier {
    private int cashierNum;
    private int customerTotal;

    private ArrayList<Customer> queueList;
    public Cashier (int CashierNum){
        this.cashierNum = CashierNum;
    }

    public void queue(){
        int customerNum;
        customerNum= new Random().nextInt(10);
        this.customerTotal = customerNum;
//        queueList.clear();
        queueList = new ArrayList<Customer>();

        for(int i = 1;i<=customerNum;i++){
            Customer customer = new Customer();
            queueList.add(customer);
        }

    }

    public int getCashierNum(){
        return cashierNum;
    }
    public ArrayList<Customer> getQueueList(){
        return queueList;
    }
    public int getCustomerTotal(){return customerTotal;}
}

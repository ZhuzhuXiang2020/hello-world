import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Cashier {
    private int cashierNum;
    private int customerTotal;
    private Queue oneQueue;

    private ArrayList<Customer> queueList = new ArrayList<Customer>();
    public Cashier (int CashierNum){
        this.cashierNum = CashierNum;
    }

    public void queue(){
        int customerNum;
        customerNum= new Random().nextInt(10);
        this.customerTotal = customerNum;
//        queueList.clear();
        oneQueue = new LinkedList<Customer>();

        for(int i = 1;i<=customerNum;i++){
            Customer customer = new Customer();
            queueList.add(customer);
            oneQueue.offer(customer);
        }

    }

    public void setCashierByQueue(Queue<Customer> queue){
        queueList.clear();

        this.customerTotal = queue.size();

        for (Customer c: queue) {
            queueList.add(c);
        }
//        while(queue.peek()!=null){
//            queueList.add((Customer) queue.poll());
//
//        }

    }

    public int getCashierNum(){
        return cashierNum;
    }
    public ArrayList<Customer> getQueueList(){
        return queueList;
    }
    public int getCustomerTotal(){return customerTotal;}
    public Queue getCashierQueue(){return oneQueue;}
}

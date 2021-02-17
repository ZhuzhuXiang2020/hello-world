import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Supermarket {

    private int cashierTotal;
    private Cashier[] cashiers;
    private ArrayList<Cashier> cashierList;
    private Queue[] allQueueList;
    public Supermarket(){
        this.initialSupermarket();
    }

    private void initialSupermarket(){
        this.cashierTotal = 5;
        this.cashiers = new Cashier[cashierTotal];
        this.allQueueList = new Queue[cashierTotal];

        cashierList = new ArrayList<Cashier>();
        //setup cashiers
        for(int i = 0; i<cashierTotal;i++){
            cashiers[i] = new Cashier(i+1);
            cashiers[i].queue();
            cashierList.add(cashiers[i]);
            allQueueList[i] = cashiers[i].getCashierQueue();
        }
    }



    public ArrayList<Cashier> getCashierList() {
        return cashierList;
    }

    public void realTimeQueueChange() throws IOException {
        System.out.println("Please select one number:");
        System.out.println("0 - add a new customer");
        System.out.println("1 - a customer left from cashier 1");
        System.out.println("2 - a customer left from cashier 2");
        System.out.println("3 - a customer left from cashier 3");
        System.out.println("4 - a customer left from cashier 4");
        System.out.println("5 - a customer left from cashier 5");
        System.out.println("6 - I want to check out");

        String iOrder;

        int id = 1;
        boolean key = true;

        while(key){
            iOrder = getQueueOrder();
            switch  (iOrder){
                case "0":
                    addNewCustomer(id);

                    id++;
                    break;
                case "1":
                    removeCustomer(0);
                    break;
                case "2":
                    removeCustomer(1);
                    break;
                case "3":
                    removeCustomer(2);
                    break;
                case "4":
                    removeCustomer(3);
                    break;
                case "5":
                    removeCustomer(4);
                    break;
                case "6":
                    key = false;
                default:
                    //do nothing
                    break;
            }

        }

        //update new queueArray
        updateCashierListOnNewQueue();
    }

    //from here is the method for queue


    private void updateCashierListOnNewQueue(){
            Cashier cashier;
        for (int i = 0; i < cashierTotal;i++) {
            cashier = cashierList.get(i);
            cashier.setCashierByQueue(allQueueList[i]);
        }
    }

//    private int getQueueOrder(){
//        int orderNum=0;
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            try{
//                orderNum = scanner.nextInt();
//                break;
//            }catch (Exception e){
//                System.out.println("Please place an order number");
//                scanner.next();
//            }
//        }
//        scanner.close();
//        return orderNum;
//    }

    private String getQueueOrder() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        String s = bf.readLine();
        return s;
    }
    private void addNewCustomer(int customerId){
        int minQueueID  = getMinCustomerQueue();
        allQueueList[minQueueID].offer(new Customer());
        System.out.println("Customer " + customerId + " add to Cashier number " + (minQueueID + 1));
    }
    private void removeCustomer(int queueID){
        Customer customer= (Customer) allQueueList[queueID].poll();
        System.out.println("Customer from queue " + (queueID+1) + " is left with " + customer.getItemsNum() + " items");
    }
    private int getMinCustomerQueue(){
        int min = 0;
        for(int i = 0; i <cashierTotal;i++){
            if(allQueueList[i].size()<allQueueList[min].size()){
                min = i;
            }
        }
        return min;
    }


}

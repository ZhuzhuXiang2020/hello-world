import java.util.ArrayList;

public class CheckOut {

    private ArrayList<Cashier> cashiers;
    private Customer myself;
    private int goToCashierNum;

    public CheckOut(ArrayList<Cashier> cashierList){
        this.cashiers = cashierList;
        this.myself = new Customer(5);
        this.goToCashierNum = CashierWithLessCustomers();
    }

    private int CashierWithLessCustomers(){
        int minCashierNum=0;
        int currentCustomerNum;
        int minCustomerNum=0;
        for(int i=0;i<cashiers.size();i++){
            currentCustomerNum = cashiers.get(i).getCustomerTotal();

            if ((minCustomerNum ==0 && minCashierNum ==0) || minCustomerNum>=currentCustomerNum){
                minCustomerNum = cashiers.get(i).getCustomerTotal();
                minCashierNum = cashiers.get(i).getCashierNum();
            }
        }
        return minCashierNum;
    }

    public int getGoToCashierNum(){return goToCashierNum;}

    public int getItemsNum(){return myself.getItemsNum();}

}

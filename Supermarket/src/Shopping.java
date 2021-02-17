import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Shopping {


    public static void main(String[] args) throws IOException {

        Supermarket supermarket = new Supermarket();
        ArrayList<Cashier> cashiers = supermarket.getCashierList();

        Iterator iterator = cashiers.iterator();
        while(iterator.hasNext()){
            Cashier cashier = (Cashier) iterator.next();
            System.out.println("Cashier number " + cashier.getCashierNum() + " has " +
                    cashier.getCustomerTotal() + " customers");
        }

        supermarket.realTimeQueueChange();
        cashiers = supermarket.getCashierList();
        CheckOut iCheckOut = new CheckOut(cashiers);
        iCheckOut.goCheckOut();

    }


}

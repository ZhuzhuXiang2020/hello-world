import java.util.ArrayList;

public class Supermarket {

    private int cashierTotal;
    private Cashier[] cashiers;
    private ArrayList<Cashier> cashierList;
    public Supermarket(){
        this.initialSupermarket();
    }

    private void initialSupermarket(){
        this.cashierTotal = 5;
        this.cashiers = new Cashier[cashierTotal];
        cashierList = new ArrayList<Cashier>();
        //setup cashiers
        for(int i = 0; i<cashierTotal;i++){
            cashiers[i] = new Cashier(i+1);
            cashiers[i].queue();
            cashierList.add(cashiers[i]);
        }
    }

    public ArrayList<Cashier> getCashierList() {
        return cashierList;
    }
}

package prob1_atmXML.register;

public class CashRegister {
    private double purchase;
    private String location;
    private TaxCalculator taxCal;

//    public CashRegister(String location, TaxCalculator taxCal) {
//        this.location = location;
//        this.taxCal = taxCal;
//    }

    public CashRegister(String location) {
        this.location = location;
    }

    public void setTaxCalculator(TaxCalculator taxCal) {
        this.taxCal = taxCal;
    }

    public void recordPurchase(double amount) {
        purchase += amount;
    }

    public double getTotal() {
        return purchase + taxCal.calculate(purchase);
    }
}

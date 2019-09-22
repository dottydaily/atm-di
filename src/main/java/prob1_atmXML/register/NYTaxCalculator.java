package prob1_atmXML.register;

public class NYTaxCalculator implements TaxCalculator {
    public double calculate(double amount) {
        if (amount <= 100) return 0;
        return amount*0.08;
    }
}

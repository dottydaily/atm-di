package prob2_atmAnnotationDI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class DataSource {

    private String filename;

    /**
     * @param filename the name of the customer file
     * we use @Value to let spring know what value will be inject into property by annotation-di
     */
    public DataSource(@Value("customers.txt") String filename) {
        this.filename = filename;
    }

    /**
     * Default constructor for annotation-di (in case that you don't want to use @Value)
     */
//    public DataSource() {
//        this.filename = "customers.txt";
//    }

    /**
     * Reads the customer numbers and pins
     * and initializes the bank accounts.
     */
    public Map<Integer, Customer> readCustomers() throws IOException {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();

        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNext()) {
            int number = in.nextInt();
            int pin = in.nextInt();
            double currentBalance = in.nextDouble();
            Customer c = new Customer(number, pin, currentBalance);
            customers.put(c.getCustomerNumber(), c);
        }
        in.close();
        return customers;
    }
}

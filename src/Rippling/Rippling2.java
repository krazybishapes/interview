/*
package Rippling;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Rippling2 {

    static class Driver{
        private String name;
        private Double payoutHourly;
        private String currency;
        private List<Delivery> deliveries;
        private Double totalPaid;
        private Double totalUnpaid;
        private long totalDeliveryTimeinSec;
        private long totalDeliveryTimeInSecUnpaid;
        public Driver(String name, Double payoutHourly){
            this.name = name;
            this.payoutHourly = payoutHourly;
        }

        public void addDelivery(Delivery delivery){
            if(this.deliveries == null){
                this.deliveries = new ArrayList<>();
            }
            this.deliveries.add(delivery);
        }


    }
    static  enum DeliveryPaymentStatus{
        PAID, UNPAID;
    }
    static class Delivery{
        private long deliveryTimeInSec;
        private DeliveryPaymentStatus deliveryPaymentStatus;
        public Delivery(long deliveryTime){
            this.deliveryTimeInSec = deliveryTime;
            this.deliveryPaymentStatus = DeliveryPaymentStatus.UNPAID;
        }
    }

    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        Driver driver = new Driver("Santosh",40.00);
        driver.addDelivery(new Delivery(300));
        drivers.add(driver);

        Driver driver1 = new Driver("Preety",10.00);
        driver1.addDelivery(new Delivery(3000));
        drivers.add(driver1);

        //long totalDeliveryTimeInSec = calculateDeliveryTime(driver1);
        System.out.println(calculateTotalUnpaid(driver));

    }

    private static Double calculateTotalUnpaid(Driver driver) {
        calculateDeliveryTime(driver);
        double hours = driver.totalDeliveryTimeInSecUnpaid / 3600.0;
        BigDecimal rounded = new BigDecimal(hours).setScale(2, RoundingMode.HALF_UP);
        double result = rounded.doubleValue();
        driver.totalUnpaid = driver.payoutHourly * (result);
        return driver.payoutHourly * (result);
    }

    private static void calculateDeliveryTime(Driver driver){
        List<Delivery> deliveries = driver.deliveries;
        long totalDeliveryTimeinSec = 0;
        long totalDeliveryTimeinSecUnpaid = 0;
        for(Delivery delivery: deliveries){
            totalDeliveryTimeinSec += delivery.deliveryTimeInSec;
            if(delivery.deliveryPaymentStatus == DeliveryPaymentStatus.UNPAID){
                totalDeliveryTimeinSecUnpaid += delivery.deliveryTimeInSec;
            }
        }
        driver.totalDeliveryTimeinSec = totalDeliveryTimeinSec;
        driver.totalDeliveryTimeInSecUnpaid = totalDeliveryTimeinSecUnpaid;
    }


}
*/

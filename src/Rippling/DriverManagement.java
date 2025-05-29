package Rippling;

import java.math.BigDecimal;
import java.util.*;

public class DriverManagement {

    Map<String, Driver> drivers = new HashMap<>();
    class Driver{
        private String name;
        private BigDecimal hourlyRate;
        private List<Delivery> deliveries;
        private long unpaidTime;
        private long totalAmountTobePaid;

        public Driver(String name){
            this.name = name;
        }

        public Driver(String name, BigDecimal hourlyRate){
            this.name = name;
            this.hourlyRate = hourlyRate;
        }

        public void setHourlyRate(BigDecimal hourlyRate){
            this.hourlyRate = hourlyRate;
        }

        public void addDelivery(Delivery delivery) throws Exception {
            if(Objects.isNull(delivery)){
                throw new Exception("Delivery can not be null");
            }
            if(deliveries == null){
                deliveries = new ArrayList<>();
            }
            deliveries.add(delivery);
        }

        public BigDecimal totalAmountTobePaid(long payTime){
            long totalDeliveryTime = 0;
            for(Delivery delivery: deliveries){
                if(delivery.isPaid) continue;
                if(delivery.endTime <= payTime){
                    totalDeliveryTime += delivery.endTime- delivery.startTime;
                }else{
                    this.unpaidTime += delivery.endTime- delivery.startTime;
                }

            }
            return hourlyRate.multiply(new BigDecimal(totalDeliveryTime/3600.0));
        }
    }



    class Delivery{
        long startTime;
        long endTime;
        boolean isPaid;

        public Delivery(long startTime, long endTime){
            this.startTime = startTime;
            this.endTime = endTime;
            this.isPaid = false;
        }
    }

    class DeliveryService{

        public BigDecimal totalAmountTobePaid(long payTime){
            BigDecimal totalAmountTobePaid = BigDecimal.ZERO;
            for(Driver driver: drivers.values()){
                totalAmountTobePaid = totalAmountTobePaid.add(driver.totalAmountTobePaid(payTime));
            }
            return totalAmountTobePaid;
        }

        public void addDelivery(String driverName, long startTime, long endTime) throws Exception {
            Driver driver = drivers.get(driverName);
            driver.addDelivery(new Delivery(1716282000L, 1716285600L));
        }
    }

    class DriverService{

        public void addDriver(String name, BigDecimal hourlyRate){
            Driver driver = new Driver(name, hourlyRate);
            drivers.put(name,driver);
        }
    }

    public static void main(String[] args) throws Exception {








    }

}

package designpattern.observer;

public class TemperatureDisplay implements Observer{

    String deviceName;

    public TemperatureDisplay(String name){
        this.deviceName = name;
    }


    @Override
    public void update(float temperature) {
        System.out.println("Temperature update is:" +temperature);
    }
}

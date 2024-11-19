package designpattern.observer;

public class ObserverDemo {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        TemperatureDisplay phoneDisplay = new TemperatureDisplay("Phone");
        TemperatureDisplay laptopDisplay = new TemperatureDisplay("Laptop");

        weatherStation.setTemperature(100f);

        weatherStation.attach(phoneDisplay);
        weatherStation.attach(laptopDisplay);

        weatherStation.notifyObserver();
    }
}

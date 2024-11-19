package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements  Subject{

    List<Observer> observers;
    float temperature;

    public void setTemperature(float temperature){
        this.temperature = temperature;
    }

    public WeatherStation(){
        this.observers = new ArrayList<>();
    }


    @Override
    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.observers.remove(observer);

    }

    @Override
    public void notifyObserver() {
        for(Observer observer: this.observers){
            observer.update(temperature);
        }

    }
}

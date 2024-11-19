package designpattern.abstractfactory;

public class YCompany implements Company{


    @Override
    public CPU assembleCPU() {
        return  new YCPU();
    }

    @Override
    public Monitor assembleMonitor() {
        return new YMonitor();
    }
}

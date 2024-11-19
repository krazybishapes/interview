package designpattern.abstractfactory;

public class XCompany implements Company{
    @Override
    public CPU assembleCPU() {
        return new XCPU();
    }

    @Override
    public Monitor assembleMonitor() {
        return new XMonitor();
    }
}

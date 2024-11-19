package designpattern.abstractfactory;

public class Abstract {

    public static void main(String[] args) {
        Company X = new XCompany();
        X.assembleCPU();
        X.assembleCPU();

        Company Y = new YCompany();
        Y.assembleMonitor();
        Y.assembleCPU();
    }
}

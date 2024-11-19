package designpattern.facade;

public class ComputerFacade {
    CPU cpu;
    Memory memory;

    public ComputerFacade(){
        this.cpu = new CPU();
        this.memory = new Memory();
    }

    public void start(){
        this.cpu.process(10);
        this.memory.load(20);
    }
}

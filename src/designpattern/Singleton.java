package designpattern;

public class Singleton {

    //why volatile - In multi threading scenario, a thread can use shared resource event if
    //object is not fully created
    public static volatile Singleton instance;

    //to protect it from reflection
    private Singleton() throws CloneNotSupportedException {
        if(instance==null){
            throw new CloneNotSupportedException("Singleton instance can not be cloned");
        }
    }

    //Handle multi threading break on singleton class
    public Singleton getSingleton() throws CloneNotSupportedException {
        //Double check- to reduce thread overhead when multiple threads are trying to get instance
        //even if objects are already created
        /*if(instance==null){
            synchronized (this){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;*/

        /*
        Improve the performance by 40 % due to not reading the objects from main memory for 2 times
        as we have made instance as volatile
         */
        Singleton result = instance;
        if(result==null){
            synchronized (this){
                result = instance;
                if(result==null){
                    result = new Singleton();
                }
            }
        }
        return result;
    }
}


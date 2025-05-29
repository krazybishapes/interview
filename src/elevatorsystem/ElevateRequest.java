package elevatorsystem;

public class ElevateRequest {
    private int srcFloor;
    private int destFloor;


    public ElevateRequest(int srcFloor, int destFloor){
        this.srcFloor = srcFloor;
        this.destFloor = destFloor;
    }

    public int getSrcFloor() {
        return srcFloor;
    }

    public void setSrcFloor(int srcFloor) {
        this.srcFloor = srcFloor;
    }

    public int getDestFloor() {
        return destFloor;
    }

    public void setDestFloor(int destFloor) {
        this.destFloor = destFloor;
    }
}

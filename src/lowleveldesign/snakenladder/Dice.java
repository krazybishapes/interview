package lowleveldesign.snakenladder;

import java.util.Random;

public class Dice {

    private int sides =6;
    private int values[] = {1,2,3,4,5,6};

    public int getValue(int index){
        return values[index];
    }

    public int roll(){
        return new Random().nextInt(sides) + 1;
    }
}

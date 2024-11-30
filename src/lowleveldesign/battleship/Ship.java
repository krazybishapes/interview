package lowleveldesign.battleship;

public class Ship {

    int size;
    char letter;
    char direction;
    Coordinate coordinate;

    public Ship(char letter, char direction, Coordinate coordinate){

        if(letter == 'A'){
            this.size = 5;
        }else if (letter == 'B'){
            this.size = 4;
        }else if(letter == 'S' || letter == 'D'){
            this.size = 3;
        }else {
            this.size = 2;
        }
        this.letter = letter;
        this.direction = direction;
        this.coordinate = coordinate;
    }

    public int getSize() {
        return size;
    }

    public char getLetter() {
        return letter;
    }

    public char getDirection() {
        return direction;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}

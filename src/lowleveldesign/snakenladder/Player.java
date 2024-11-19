package lowleveldesign.snakenladder;

public class Player {

    private int id;
    private String name;
    private int position;
    private PlayerStatus status;

    public Player(int id, String name){
        this.id = id;
        this.name = name;
        this.position = 0;
        this.status = PlayerStatus.IN_PLAY;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void move(int steps){
        this.position += steps;

    }

    public int getCurrentPosition(){
        return this.position;
    }

    public PlayerStatus getStatus() {
        return status;
    }

    public void setStatus(PlayerStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

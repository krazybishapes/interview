package lowleveldesign.tictactielld;

public class Player {

    private int id;
    private String name;
    private WinStatus winStatus = WinStatus.RUNNER;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WinStatus getWinStatus() {
        return winStatus;
    }

    public void setWinStatus(WinStatus winStatus) {
        this.winStatus = winStatus;
    }
}

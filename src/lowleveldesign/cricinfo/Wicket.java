package lowleveldesign.cricinfo;

public class Wicket {

    private int id;
    private Player bowler;
    private Player batsMan;
    private WicketType wicketType;
    private Player caughtBy;
    private Player runOutBy;
    private Ball ball;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getBowler() {
        return bowler;
    }

    public void setBowler(Player bowler) {
        this.bowler = bowler;
    }

    public Player getBatsMan() {
        return batsMan;
    }

    public void setBatsMan(Player batsMan) {
        this.batsMan = batsMan;
    }

    public WicketType getWicketType() {
        return wicketType;
    }

    public void setWicketType(WicketType wicketType) {
        this.wicketType = wicketType;
    }

    public Player getCaughtBy() {
        return caughtBy;
    }

    public void setCaughtBy(Player caughtBy) {
        this.caughtBy = caughtBy;
    }

    public Player getRunOutBy() {
        return runOutBy;
    }

    public void setRunOutBy(Player runOutBy) {
        this.runOutBy = runOutBy;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }
}

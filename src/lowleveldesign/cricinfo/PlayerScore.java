package lowleveldesign.cricinfo;

public class PlayerScore {

    private int id;
    private int teamScoreId;
    private int playerId;
    private int totalWickets;
    private int toalRuns;
    private int toalCatch;
    private int numberOfBallsPlayed;
    private int strikeRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamScoreId() {
        return teamScoreId;
    }

    public void setTeamScoreId(int teamScoreId) {
        this.teamScoreId = teamScoreId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTotalWickets() {
        return totalWickets;
    }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public int getToalRuns() {
        return toalRuns;
    }

    public void setToalRuns(int toalRuns) {
        this.toalRuns = toalRuns;
    }

    public int getToalCatch() {
        return toalCatch;
    }

    public void setToalCatch(int toalCatch) {
        this.toalCatch = toalCatch;
    }

    public int getNumberOfBallsPlayed() {
        return numberOfBallsPlayed;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed) {
        this.numberOfBallsPlayed = numberOfBallsPlayed;
    }

    public int getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(int strikeRate) {
        this.strikeRate = strikeRate;
    }
}

package lowleveldesign.cricinfo;

public class Innings {

    private int id;
    private int matchId;
    private String name;
    private int totalNumOfOvers;
    private int totalOverPlayed;
    private String ballingTeamId;
    private String battingTeamId;


    public String getBattingTeamId() {
        return battingTeamId;
    }

    public void setBattingTeamId(String battingTeamId) {
        this.battingTeamId = battingTeamId;
    }

    public String getBallingTeamId() {
        return ballingTeamId;
    }

    public void setBallingTeamId(String ballingTeamId) {
        this.ballingTeamId = ballingTeamId;
    }

    public int getTotalOverPlayed() {
        return totalOverPlayed;
    }

    public void setTotalOverPlayed(int totalOverPlayed) {
        this.totalOverPlayed = totalOverPlayed;
    }

    public int getTotalNumOfOvers() {
        return totalNumOfOvers;
    }

    public void setTotalNumOfOvers(int totalNumOfOvers) {
        this.totalNumOfOvers = totalNumOfOvers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

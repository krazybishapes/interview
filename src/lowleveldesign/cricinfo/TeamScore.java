package lowleveldesign.cricinfo;

import java.util.List;

public class TeamScore {

    private int id;
    private int teamId;
    private int scoreCardId;
    private int totalScore;
    private int totalWicket;
    List<PlayerScore> playerScores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getScoreCardId() {
        return scoreCardId;
    }

    public void setScoreCardId(int scoreCardId) {
        this.scoreCardId = scoreCardId;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalWicket() {
        return totalWicket;
    }

    public void setTotalWicket(int totalWicket) {
        this.totalWicket = totalWicket;
    }

    public List<PlayerScore> getPlayerScores() {
        return playerScores;
    }

    public void setPlayerScores(List<PlayerScore> playerscores) {
        this.playerScores = playerscores;
    }
}

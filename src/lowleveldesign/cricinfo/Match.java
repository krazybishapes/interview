package lowleveldesign.cricinfo;

import java.time.LocalDateTime;
import java.util.List;

public class Match {

    private int id;
    private String tournametId;
    private String name;
    private Team A;
    private Team B;
    private String playGround;
    private LocalDateTime matchStartTime;
    private LocalDateTime matchEndTime;
    private MatchStatus matchStatus;
    private int numOfOvers;
    private List<Innings> innings;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTournametId() {
        return tournametId;
    }

    public void setTournametId(String tournametId) {
        this.tournametId = tournametId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getA() {
        return A;
    }

    public void setA(Team a) {
        A = a;
    }

    public Team getB() {
        return B;
    }

    public void setB(Team b) {
        B = b;
    }

    public String getPlayGround() {
        return playGround;
    }

    public void setPlayGround(String playGround) {
        this.playGround = playGround;
    }

    public LocalDateTime getMatchStartTime() {
        return matchStartTime;
    }

    public void setMatchStartTime(LocalDateTime matchStartTime) {
        this.matchStartTime = matchStartTime;
    }

    public LocalDateTime getMatchEndTime() {
        return matchEndTime;
    }

    public void setMatchEndTime(LocalDateTime matchEndTime) {
        this.matchEndTime = matchEndTime;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    public int getNumOfOvers() {
        return numOfOvers;
    }

    public void setNumOfOvers(int numOfOvers) {
        this.numOfOvers = numOfOvers;
    }

    public List<Innings> getInnings() {
        return innings;
    }

    public void setInnings(List<Innings> innings) {
        this.innings = innings;
    }
}

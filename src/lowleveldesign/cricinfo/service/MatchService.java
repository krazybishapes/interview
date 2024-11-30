package lowleveldesign.cricinfo.service;

import lowleveldesign.cricinfo.Innings;
import lowleveldesign.cricinfo.Match;

public interface MatchService {

    public void addMatch(Match match);
    public Match getMatchDetails(Integer matchId);
    public void updateMatch(Match match);
    public void addInning(Integer matchId, Innings innings);
}

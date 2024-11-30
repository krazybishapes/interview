package lowleveldesign.cricinfo.service;

import lowleveldesign.cricinfo.Innings;
import lowleveldesign.cricinfo.Match;

import java.util.Map;

public class MatchServiceImpl implements MatchService{

    private static MatchService instance = null;
    Map<Integer, Match> matches;

    private MatchServiceImpl(){
    }

    public static MatchService getInstance(){
        if(instance == null){
            synchronized (MatchServiceImpl.class){
                if(instance == null){
                    instance = new MatchServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void addMatch(Match match) {
        matches.put(match.getId(),match);
    }

    @Override
    public Match getMatchDetails(Integer matchId) {
        return matches.get(matchId);
    }

    @Override
    public void updateMatch(Match match) {
        matches.put(match.getId(), match);
    }

    @Override
    public void addInning(Integer matchId, Innings innings) {
        matches.get(matchId).getInnings().add(innings);
    }
}

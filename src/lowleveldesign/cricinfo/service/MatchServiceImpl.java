package lowleveldesign.cricinfo.service;

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
    public Match getMatchDetails(Match match) {
        return null;
    }

    @Override
    public void updateMatch(Match match) {

    }
}

package lowleveldesign.cricinfo.service;

import lowleveldesign.cricinfo.ScoreCard;

public interface ScoreCardService {

    public void addOrUpdateScoreCard(ScoreCard scoreCard);
    public ScoreCard getScoreCardDetails(String inningId);

}

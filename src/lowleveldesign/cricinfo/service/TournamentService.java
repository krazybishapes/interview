package lowleveldesign.cricinfo.service;

import lowleveldesign.cricinfo.Tournament;

public interface TournamentService {

    public void addTournament(Tournament tournament);
    public Tournament getTournament(String tournamentId);
    public void updateTournament(Tournament tournament);
}

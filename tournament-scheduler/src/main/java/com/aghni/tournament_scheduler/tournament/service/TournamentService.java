package com.aghni.tournament_scheduler.tournament.service;

import com.aghni.tournament_scheduler.tournament.exception.TournamentNameAlreadyExistsException;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentRequest;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentResponse;
import org.springframework.stereotype.Service;

@Service
public interface TournamentService {

    public AddTournamentResponse createTournament(AddTournamentRequest addTournamentRequest) throws TournamentNameAlreadyExistsException;

}

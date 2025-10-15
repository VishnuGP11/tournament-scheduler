package com.aghni.tournament_scheduler.tournament.controller;

import com.aghni.tournament_scheduler.tournament.exception.TournamentNameAlreadyExistsException;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentRequest;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentResponse;
import com.aghni.tournament_scheduler.tournament.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping("/addTournament")
    public ResponseEntity<AddTournamentResponse> createTournament(@RequestBody AddTournamentRequest addTournamentRequest) throws TournamentNameAlreadyExistsException {
        return new ResponseEntity<>(tournamentService.createTournament(addTournamentRequest), HttpStatus.OK);
    }

}

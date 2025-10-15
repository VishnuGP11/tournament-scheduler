package com.aghni.tournament_scheduler.tournament.service;

import com.aghni.tournament_scheduler.team.entity.Team;
import com.aghni.tournament_scheduler.tournament.entity.Tournament;
import com.aghni.tournament_scheduler.tournament.exception.TournamentNameAlreadyExistsException;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentRequest;
import com.aghni.tournament_scheduler.tournament.model.AddTournamentResponse;
import com.aghni.tournament_scheduler.tournament.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TournamentServiceImpl implements TournamentService {

    Logger logger = Logger.getLogger(TournamentServiceImpl.class.getName());

    @Autowired
    private TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public AddTournamentResponse createTournament(AddTournamentRequest addTournamentRequest) throws TournamentNameAlreadyExistsException {

            if (tournamentRepository.existsByTournamentName(addTournamentRequest.getTournamentName())) {
                logger.severe("Tournament name with name " +'"'+ addTournamentRequest.getTournamentName()+'"' + " already exists");
                throw new TournamentNameAlreadyExistsException("Tournament name already exists");
            }

        Tournament tournament = new Tournament();
        tournament.setTournamentName(addTournamentRequest.getTournamentName());
        tournament.setNumberOfTeams(addTournamentRequest.getNumberOfTeams());
        tournament.setTypeOfSchedule(addTournamentRequest.getTypeOfSchedule());

        List<Team> teams = new ArrayList<>();
        for(int i=1; i<=addTournamentRequest.getNumberOfTeams(); i++){
            Team team = new Team("Team "+i+" - "+addTournamentRequest.getTournamentName());
            team.setTournament(tournament);
            teams.add(team);
        }
        tournament.setTeams(teams);


        Tournament savedTournament = tournamentRepository.save(tournament);
        logger.info("Saved Tournament of name : " + savedTournament.getTournamentName());
        AddTournamentResponse response = new AddTournamentResponse();
        if (savedTournament != null && savedTournament.getTournamentId() != null) {
            response.setDate(LocalDate.now());
            response.setMessage("Tournament created successfully");
            response.setStatus("success");
        } else {
            response.setDate(LocalDate.now());
            response.setMessage("Tournament creation failed");
            response.setStatus("failure");
        }

        return response;


    }
}

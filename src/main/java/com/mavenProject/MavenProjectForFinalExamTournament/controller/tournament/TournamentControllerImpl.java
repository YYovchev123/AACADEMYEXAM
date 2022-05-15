package com.mavenProject.MavenProjectForFinalExamTournament.controller.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.converter.tournament.TournamentConverter;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.tournament.TournamentSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;
import com.mavenProject.MavenProjectForFinalExamTournament.service.tournament.TournamentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/tournaments")
public class TournamentControllerImpl implements TournamentController{

    private final TournamentService tournamentService;
    private final TournamentConverter tournamentConverter;

    @Override
    @PostMapping
    public ResponseEntity<TournamentResponse> save(@RequestBody @Valid TournamentSaveRequest tournamentSaveRequest) {
        Tournament tournament = tournamentConverter.convert(tournamentSaveRequest);
        Tournament savedTournament = tournamentService.save(tournament);
        TournamentResponse tournamentResponse = tournamentConverter.convert(savedTournament);
        return ResponseEntity.status(HttpStatus.CREATED).body(tournamentResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TournamentResponse>> findAll() {
        return ResponseEntity.ok(tournamentService.findAll().stream().map(tournamentConverter::convert).collect(Collectors.toList()));
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<TournamentResponse> findByName(@PathVariable String name) {
        Tournament tournament = tournamentService.findByName(name);
        TournamentResponse tournamentResponse = tournamentConverter.convert(tournament);
        return ResponseEntity.ok().body(tournamentResponse);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<TournamentResponse> findById(@PathVariable Long id) {
        Tournament tournament = tournamentService.findById(id);
        TournamentResponse tournamentResponse = tournamentConverter.convert(tournament);
        return ResponseEntity.ok().body(tournamentResponse);
    }

    @Override
    @DeleteMapping(value = "/delete/name/{name}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable  Long id) {
        tournamentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/delete/id/{id}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable  String name) {
        tournamentService.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}

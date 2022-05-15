package com.mavenProject.MavenProjectForFinalExamTournament.controller.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.converter.sportClub.SportClubConverter;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sportClub.SportClubSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;
import com.mavenProject.MavenProjectForFinalExamTournament.service.sportClub.SportClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/sportClubs")
public class SportClubControllerImpl implements SportClubController{

    private final SportClubService sportClubService;

    private final SportClubConverter sportClubConverter;

    @Override
    @PostMapping
    public ResponseEntity<SportClubResponse> save(@RequestBody @Valid SportClubSaveRequest sportClubSaveRequest) {
        SportClub sportClub = sportClubConverter.convert(sportClubSaveRequest);
        SportClub savedSportClub = sportClubService.save(sportClub);
        SportClubResponse sportClubResponse = sportClubConverter.convert(savedSportClub);
        return ResponseEntity.ok().body(sportClubResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<SportClubResponse>> findAll() {
        return ResponseEntity.ok().body(sportClubService.findAll().stream().map(sportClubConverter::convert).collect(Collectors.toList()));
    }

    @Override
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<SportClubResponse> findByName(@PathVariable String name) {
        SportClub sportClub = sportClubService.findByName(name);
        SportClubResponse sportClubResponse = sportClubConverter.convert(sportClub);
        return ResponseEntity.ok().body(sportClubResponse);
    }

    @Override
    @GetMapping(value = "/id/{id}")
    public ResponseEntity<SportClubResponse> findById(@PathVariable Long id) {
        SportClub sportClub = sportClubService.findById(id);
        SportClubResponse sportClubResponse = sportClubConverter.convert(sportClub);
        return ResponseEntity.ok().body(sportClubResponse);
    }

    @Override
    @DeleteMapping(value = "/delete/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        sportClubService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/delete/name/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        sportClubService.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}

package com.mavenProject.MavenProjectForFinalExamTournament.controller.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.converter.sport.SportConverter;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportResponse;
import com.mavenProject.MavenProjectForFinalExamTournament.dto.sport.SportSaveRequest;
import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import com.mavenProject.MavenProjectForFinalExamTournament.service.sport.SportService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/sports")
public class SportControllerImpl implements SportController{

    private final SportService sportService;
    private final SportConverter sportConverter;

    @Override
    @PostMapping
    public ResponseEntity<SportResponse> save(@RequestBody @Valid SportSaveRequest sportSaveRequest) {
        Sport sport = sportConverter.convert(sportSaveRequest);
        Sport savedSport = sportService.save(sport);
        SportResponse sportResponse = sportConverter.convert(savedSport);
        return ResponseEntity.ok().body(sportResponse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<SportResponse>> findAll() {
        return ResponseEntity.ok(sportService.findAll().stream().map(sportConverter::convert).collect(Collectors.toList()));
    }

    @Override
    @GetMapping(value = "id/{id}")
    public ResponseEntity<SportResponse> findById(@PathVariable Long id) {
        Sport sport = sportService.findById(id);
        SportResponse sportResponse = sportConverter.convert(sport);
        return ResponseEntity.ok().body(sportResponse);
    }

    @Override
    @GetMapping(value = "name/{name}")
    public ResponseEntity<SportResponse> findByName(@PathVariable String name) {
        Sport sport = sportService.findByName(name);
        SportResponse sportResponse = sportConverter.convert(sport);
        return ResponseEntity.ok().body(sportResponse);
    }

    @Override
    @DeleteMapping(value = "/delete/id/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        sportService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @DeleteMapping(value = "/delete/name/{name}")
    public ResponseEntity<HttpStatus> deleteByName(@PathVariable String name) {
        sportService.deleteByName(name);
        return ResponseEntity.ok().build();
    }
}

package com.mavenProject.MavenProjectForFinalExamTournament.service.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;

import java.util.List;


public interface TournamentService {

    Tournament save(Tournament tournament);

    List<Tournament> findAll();

    Tournament findById(Long id);

    Tournament findByName(String name);

    void deleteById(Long id);

    void deleteByName(String name);
}

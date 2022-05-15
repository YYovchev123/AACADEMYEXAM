package com.mavenProject.MavenProjectForFinalExamTournament.service.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;

import java.util.List;

public interface SportService {

    Sport save(Sport sport);

    List<Sport> findAll();

    Sport findById(Long id);

    Sport findByName(String name);

    void deleteById(Long id);

    void deleteByName(String name);
}

package com.mavenProject.MavenProjectForFinalExamTournament.repositroy;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {

    Optional<Tournament> findByName(String name);

    void deleteByName(String name);
}

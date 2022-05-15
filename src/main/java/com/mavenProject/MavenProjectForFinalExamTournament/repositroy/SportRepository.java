package com.mavenProject.MavenProjectForFinalExamTournament.repositroy;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

    Optional<Sport> findByName(String name);

    void deleteByName(String name);
}

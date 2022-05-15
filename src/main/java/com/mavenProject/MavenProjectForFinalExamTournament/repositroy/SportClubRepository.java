package com.mavenProject.MavenProjectForFinalExamTournament.repositroy;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SportClubRepository extends JpaRepository<SportClub, Long> {

    Optional<SportClub> findByName(String name);

    void deleteByName(String name);
}

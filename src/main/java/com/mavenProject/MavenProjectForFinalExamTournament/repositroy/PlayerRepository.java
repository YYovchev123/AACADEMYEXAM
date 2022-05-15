package com.mavenProject.MavenProjectForFinalExamTournament.repositroy;


import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Optional<Player> findByName(String name);

    void deleteByName(String name);
}

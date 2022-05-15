package com.mavenProject.MavenProjectForFinalExamTournament.service.player;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Player;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.PlayerRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Primary
public class PlayerServiceImpl implements PlayerService{

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }


    @Override
    public Player save(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player update(Player updatedPlayer, Long id) {
        Player player = findById(id);
        player.setName(updatedPlayer.getName());
        player.setAge(updatedPlayer.getAge());
        return player;
    }

    @Override
    public Player findByName(String name) {
        return playerRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(String.format("Играч с име %s не е намерен", name)));
    }

    @Override
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Играч с ID %s не е намерен" , id)));
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        playerRepository.deleteByName(name);
    }
}

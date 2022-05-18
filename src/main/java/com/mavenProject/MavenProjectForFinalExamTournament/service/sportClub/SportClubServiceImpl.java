package com.mavenProject.MavenProjectForFinalExamTournament.service.sportClub;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.SportClub;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.SportClubRepository;
import com.mavenProject.MavenProjectForFinalExamTournament.service.player.PlayerService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Primary
public class SportClubServiceImpl implements SportClubService{

    private final SportClubRepository sportClubRepository;
    //private final PlayerService playerService;

    public SportClubServiceImpl(SportClubRepository sportClubRepository) {
        this.sportClubRepository = sportClubRepository;
    }

    @Override
    public SportClub save(SportClub sportClub) {
        return sportClubRepository.save(sportClub);
    }

    @Override
    public List<SportClub> findAll() {
        return sportClubRepository.findAll();
    }

    @Override
    public SportClub update(SportClub updatedSportClub, Long id) {
        SportClub sportClub = findById(id);
        sportClub.setName(updatedSportClub.getName());
        sportClub.setSport(updatedSportClub.getSport());
        return sportClub;
    }

    @Override
    public SportClub findByName(String name) {
        return sportClubRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(String.format("Клуб с име %s не е намерен", name)));
    }

    @Override
    public SportClub findById(Long id) {
        return sportClubRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Клуб с ID %s не е намерен", id)));
    }

    @Override
    public void deleteById(Long id) {
        sportClubRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        sportClubRepository.deleteByName(name);
    }
}

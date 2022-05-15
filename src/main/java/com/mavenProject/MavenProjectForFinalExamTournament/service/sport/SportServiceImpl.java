package com.mavenProject.MavenProjectForFinalExamTournament.service.sport;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Sport;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.SportRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Primary
public class SportServiceImpl implements SportService{

    private final SportRepository sportRepository;

    public SportServiceImpl(SportRepository sportRepository){
        this.sportRepository = sportRepository;
    }

    @Override
    public Sport save(Sport sport) {
        return sportRepository.save(sport);
    }

    @Override
    public List<Sport> findAll() {
            return sportRepository.findAll();
    }

    @Override
    public Sport findById(Long id) {
        return sportRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Спорт с ID %s не е намерен" , id)));
    }

    @Override
    public Sport findByName(String name) {
        return sportRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(String.format("Спорт с име %s не е намерен" , name)));
    }

    @Override
    public void deleteById(Long id) {
        sportRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        sportRepository.deleteByName(name);
    }
}

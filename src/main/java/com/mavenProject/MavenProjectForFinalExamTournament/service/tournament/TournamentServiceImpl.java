package com.mavenProject.MavenProjectForFinalExamTournament.service.tournament;

import com.mavenProject.MavenProjectForFinalExamTournament.entitiy.Tournament;
import com.mavenProject.MavenProjectForFinalExamTournament.exception.RecordNotFoundException;
import com.mavenProject.MavenProjectForFinalExamTournament.repositroy.TournamentRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Primary
public class TournamentServiceImpl implements TournamentService{

    private final TournamentRepository tournamentRepository;

    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Tournament save(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    @Override
    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament findById(Long id) {
        return tournamentRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Турнир с ID %s не е намерен!", id)));
    }

    @Override
    public Tournament findByName(String name) {
        return tournamentRepository.findByName(name).orElseThrow(() -> new RecordNotFoundException(String.format("Турнир с име %s не е намерен!", name)));
    }

    @Override
    public void deleteById(Long id) {
        tournamentRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String name) {
        tournamentRepository.deleteByName(name);
    }
}

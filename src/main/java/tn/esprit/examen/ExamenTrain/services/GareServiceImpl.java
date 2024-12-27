package tn.esprit.examen.ExamenTrain.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.ExamenTrain.entities.Gare;
import tn.esprit.examen.ExamenTrain.repositories.IGareRepository;

@AllArgsConstructor
@Service
public class GareServiceImpl implements IGareService {
    private final IGareRepository gareRepository;

    @Override
    public void ajouterGare(Gare g) {
        gareRepository.save(g);
    }
}

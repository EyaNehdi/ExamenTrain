package tn.esprit.examen.ExamenTrain.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.ExamenTrain.entities.Gare;
import tn.esprit.examen.ExamenTrain.entities.Train;
import tn.esprit.examen.ExamenTrain.repositories.IGareRepository;
import tn.esprit.examen.ExamenTrain.repositories.ITrainRepository;


@AllArgsConstructor
@Service
public class TrainServiceImpl implements ITrainService{
    private final ITrainRepository trainRepository;
    private final IGareRepository gareRepository;

    @Override
    public void ajouterTrain(Train train) {
        trainRepository.save(train);
    }

    @Override
    public void affecterTrainAGare(Long idTrain, Long idGareDepart, Long idGareArrivee) {
        Train train = trainRepository.findById(idTrain).orElse(null);
        Gare gareDepart = gareRepository.findById(idGareDepart).orElse(null);
        Gare gareArrivee = gareRepository.findById(idGareArrivee).orElse(null);
        if ( gareDepart!=gareArrivee){
            train.setVient(gareDepart);
            train.setVaVers(gareArrivee);
        }
trainRepository.save(train);
    }
}

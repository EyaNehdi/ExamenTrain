package tn.esprit.examen.ExamenTrain.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.examen.ExamenTrain.entities.Gare;
import tn.esprit.examen.ExamenTrain.entities.Train;
import tn.esprit.examen.ExamenTrain.entities.etatTrain;
import tn.esprit.examen.ExamenTrain.repositories.IGareRepository;
import tn.esprit.examen.ExamenTrain.repositories.ITrainRepository;

import java.util.Date;
import java.util.List;


@Slf4j
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

//    @Override
//    public int TrainPlacesLibres(Long idGareDepart) {
//        Gare gare = gareRepository.findById(idGareDepart).get();
//         return trainRepository.AvgNbPlacesLibre(gare.getLocalisation());
//    }

    @Override
    public List<Train> ListerTrainsIndirects(Long idGareDepart, Long idGareArrivee) {
        return trainRepository.findAllByGareDepartAndGareArrivee(idGareDepart,idGareArrivee);
    }


//    @Override
//    public void DesaffecterClientsTrain(Long idGareDepart, double heureDepart) {
//        Gare gare = gareRepository.findById(idGareDepart).orElse(null);
//
//    }

    @Scheduled(fixedRate = 30000)
    @Override
    public void TrainsEnGare() {
        Date sysDate = new Date();
        List<Train> trainList = (List<Train>) trainRepository.findAll();
        for (Train train : trainList){
            if (train.getDateArrivee().before(sysDate)){
                train.setEtat(etatTrain.EN_GARE);
                trainRepository.save(train);
                System.out.println("Train = " +train);
            }
        }
    }
}

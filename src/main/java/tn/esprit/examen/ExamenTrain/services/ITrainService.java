package tn.esprit.examen.ExamenTrain.services;

import tn.esprit.examen.ExamenTrain.entities.Train;

import java.util.List;

public interface ITrainService {
    public void ajouterTrain (Train train);
    public void affecterTrainAGare(Long idTrain,Long idGareDepart,Long idGareArrivee);
//    public int TrainPlacesLibres(Long idGareDepart);
    public List<Train> ListerTrainsIndirects(Long idGareDepart, Long idGareArrivee);
//    public void DesaffecterClientsTrain(Long idGareDepart,double heureDepart);
public void TrainsEnGare();
}

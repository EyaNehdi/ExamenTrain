package tn.esprit.examen.ExamenTrain.services;

import tn.esprit.examen.ExamenTrain.entities.Train;

public interface ITrainService {
    public void ajouterTrain (Train train);
    public void affecterTrainAGare(Long idTrain,Long idGareDepart,Long idGareArrivee);
}

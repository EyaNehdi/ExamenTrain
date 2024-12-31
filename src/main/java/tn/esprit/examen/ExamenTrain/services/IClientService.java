package tn.esprit.examen.ExamenTrain.services;

import tn.esprit.examen.ExamenTrain.entities.Client;

public interface IClientService {
    public void ajouterClient (Client c);
    public void affecterTainAClient(Long idClient,Long idGareDepart);
}

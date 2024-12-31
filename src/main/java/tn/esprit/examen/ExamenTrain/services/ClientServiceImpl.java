package tn.esprit.examen.ExamenTrain.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.ExamenTrain.entities.Client;
import tn.esprit.examen.ExamenTrain.entities.Train;
import tn.esprit.examen.ExamenTrain.repositories.IClientRepository;
import tn.esprit.examen.ExamenTrain.repositories.ITrainRepository;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements IClientService{
    private final IClientRepository clientRepository;
    private final ITrainRepository trainRepository;

    @Override
    public void ajouterClient(Client c) {
        clientRepository.save(c);
    }

    @Override
    public void affecterTainAClient(Long idClient, Long idGareDepart) {
        Client client = clientRepository.findById(idClient).orElse(null);
        Train train = trainRepository.findById(idGareDepart).orElse(null);
        if (train.getNbPlaceLibre()>2){
        client.setTrain(train);
        train.setNbPlaceLibre(train.getNbPlaceLibre() - 1);
        clientRepository.save(client);}
        else {
            System.out.println("Pas de place disponible/n");
        }
    }
}

package tn.esprit.examen.ExamenTrain.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.ExamenTrain.entities.Client;
import tn.esprit.examen.ExamenTrain.repositories.IClientRepository;

@AllArgsConstructor
@Service
public class ClientServiceImpl implements IClientService{
    private final IClientRepository clientRepository;

    @Override
    public void ajouterClient(Client c) {
        clientRepository.save(c);
    }
}

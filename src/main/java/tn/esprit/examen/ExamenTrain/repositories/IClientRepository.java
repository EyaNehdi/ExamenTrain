package tn.esprit.examen.ExamenTrain.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.examen.ExamenTrain.entities.Client;

public interface IClientRepository extends CrudRepository<Client,Long> {
}

package tn.esprit.examen.ExamenTrain.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.examen.ExamenTrain.entities.Train;

public interface ITrainRepository extends CrudRepository<Train,Long> {
}

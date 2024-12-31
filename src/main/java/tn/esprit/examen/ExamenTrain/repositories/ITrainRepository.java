package tn.esprit.examen.ExamenTrain.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.examen.ExamenTrain.entities.Train;
import tn.esprit.examen.ExamenTrain.entities.Ville;

import java.util.List;

public interface ITrainRepository extends CrudRepository<Train,Long> {

    @Query("select avg(t.nbPlaceLibre) from Train t where t.vient.localisation=:localisation")
    public int AvgNbPlacesLibre(@Param("localisation") Ville localisation);

    @Query("select t from Train t where t.vient.idGare=:idGareDepart AND t.vaVers.idGare!=:idGareArrivee")
    public List<Train> findAllByGareDepartAndGareArrivee(@Param("idGareDepart") Long idGareDepart,@Param("idGareArrivee") Long idGareArrivee);
}

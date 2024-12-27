package tn.esprit.examen.ExamenTrain.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.examen.ExamenTrain.entities.Gare;
import tn.esprit.examen.ExamenTrain.services.IGareService;

@Tag(name = "\uD83D\uDCDA Gare Management")
@RestController
@RequestMapping("gare")
@RequiredArgsConstructor
public class GareRestController {
    private final IGareService gareService;
    @PostMapping("/addGare")
    public void ajouterGare(@RequestBody Gare g){
        gareService.ajouterGare(g);
    }
}

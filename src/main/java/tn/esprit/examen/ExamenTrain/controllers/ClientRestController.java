package tn.esprit.examen.ExamenTrain.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.ExamenTrain.entities.Client;
import tn.esprit.examen.ExamenTrain.services.IClientService;

@Tag(name = "\uD83D\uDCDA Client Management")
@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientRestController {
    private final IClientService clientService;

    @PostMapping("/addClient")
    public void ajouterClient(@RequestBody Client c){
        clientService.ajouterClient(c);
    }
@PutMapping("/affecter/{idClient}/{idGareDepart}")
    public void affecterTainAClient(@PathVariable("idClient") Long idClient,@PathVariable("idGareDepart") Long idGareDepart){
        clientService.affecterTainAClient(idClient,idGareDepart);
    }
}

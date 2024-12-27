package tn.esprit.examen.ExamenTrain.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}

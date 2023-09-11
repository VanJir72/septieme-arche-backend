package fr.demos.septemearchebackend.controller;


import fr.demos.septemearchebackend.exceptions.CommandeLineNotFoundException;
import fr.demos.septemearchebackend.model.CommandeLine;
import fr.demos.septemearchebackend.service.CommandeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/commandeLines")
public class CommandeLineController {


    @Autowired
    private final CommandeLineService commandeLineServices;

    public CommandeLineController(CommandeLineService commandeLineServices) {
        this.commandeLineServices = commandeLineServices;
    }



    @GetMapping()
    public List<CommandeLine> getAllCommandeLines() throws CommandeLineNotFoundException {
        List<CommandeLine> commandeLines = commandeLineServices.getAllCommandeLines();
        if (commandeLines.size() > 0) {
            return commandeLines;
        } else {
            throw new CommandeLineNotFoundException("Pas de resultat !");
        }
    }
}

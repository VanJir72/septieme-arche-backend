package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.CommandeLine;

import java.util.List;
import java.util.Optional;


public interface CommandeLineService {

    CommandeLine createCommandeLine(CommandeLine commandeLine);

    List<CommandeLine> getAllCommandeLines();

    Optional<CommandeLine> getCommandeLineById(Long id);

    CommandeLine updateCommandeLine(CommandeLine commandeLine);

    String deleteCommandeLine(Long id);
}

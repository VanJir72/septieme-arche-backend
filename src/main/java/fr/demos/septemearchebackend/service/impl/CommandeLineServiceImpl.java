package fr.demos.septemearchebackend.service.impl;

import fr.demos.septemearchebackend.model.CommandeLine;
import fr.demos.septemearchebackend.repository.CommandeLineRepository;
import fr.demos.septemearchebackend.service.CommandeLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeLineServiceImpl implements CommandeLineService {

    @Autowired
    private final CommandeLineRepository commandeLineRepository;

    public CommandeLineServiceImpl(CommandeLineRepository commandeLineRepository) {
        this.commandeLineRepository = commandeLineRepository;
    }

    @Override
    public CommandeLine createCommandeLine(CommandeLine commandeLine) {
        return null;
    }

    @Override
    public List<CommandeLine> getAllCommandeLines() {
        return commandeLineRepository.findAll();
    }

    @Override
    public Optional<CommandeLine> getCommandeLineById(Long id) {
        return Optional.empty();
    }

    @Override
    public CommandeLine updateCommandeLine(CommandeLine lignecommande) {
        return null;
    }

    @Override
    public String deleteCommandeLine(Long id) {
        return null;
    }
}

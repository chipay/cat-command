package org.chipay.cat.commands;

import org.chipay.cat.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;

@Component
public class CatCommands implements CommandMarker {

    private final CatService catService;

    @Autowired
    public CatCommands(CatService catService) {
        this.catService = catService;
    }


    @CliAvailabilityIndicator({"cat fact"})
    public boolean isFactAvailable() {
        //always available
        return true;
    }

    @CliCommand(value = "cat fact", help = "Shows a random cat fact")
    public String fact() {
        return this.catService.getFact();
    }

}

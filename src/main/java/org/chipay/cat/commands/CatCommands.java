package org.chipay.cat.commands;

import org.apache.commons.io.FileUtils;
import org.chipay.cat.CatService;
import org.chipay.cat.response.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class CatCommands implements CommandMarker {

    private final CatService catService;

    @Autowired
    public CatCommands(CatService catService) {
        this.catService = catService;
    }


    @CliAvailabilityIndicator({"cat fact"})
    public boolean isFactAvailable() {
        return true;
    }

    @CliAvailabilityIndicator({"cat file"})
    public boolean isFileAvailable() {
        return true;
    }

    @CliAvailabilityIndicator({"cat categories"})
    public boolean isCategoriesAvailable() {
        return true;
    }

    @CliCommand(value = "cat fact", help = "Shows a random cat fact")
    public String fact() {
        return this.catService.getFact();
    }

    @CliCommand(value = "cat file", help = "Gets and saves a random cat image")
    public String file(
            @CliOption(key = {"path"}, mandatory = true,
                    help = "Where you are saving the file?", specifiedDefaultValue = "catImage.jpg")
            final String path) {
        try {
            URL url = this.catService.getImageURL();
            File file = new File(path);
            FileUtils.copyURLToFile(url, file);
            System.out.println("File saved");
            return url.toString();
        } catch( Exception e) {
            System.err.println(e.getMessage());
            return "Error";
        }
    }

    @CliCommand(value = "cat categories", help = "Shows the sorted cat categories")
    public String categories() {
        List<Category> categories = this.catService.getCategories();
        Collections.sort(categories, new Comparator<Category>() {

            @Override
            public int compare(Category o1, Category o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return categories.toString();
    }
}

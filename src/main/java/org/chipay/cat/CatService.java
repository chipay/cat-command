package org.chipay.cat;

import org.chipay.cat.response.Category;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public interface CatService {

    /**
     * Gets a random cat fact.
     *
     * @return String The fact
     */
    String getFact();

    /**
     * Gets a random cat image URL
     *
     * @return The cat image URL
     */
    URL getImageURL() throws MalformedURLException;

    /**
     * Gets cat image categories
     *
     * @return The categories
     */
    List<Category> getCategories();
}

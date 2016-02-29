package org.chipay.cat;

import java.net.MalformedURLException;
import java.net.URL;

public interface CatService {

    /**
     * Gets a random cat fact.
     *
     * @return String The fact
     */
    String getFact();

    URL getImageURL() throws MalformedURLException;
}

package org.chipay.cat;

import org.chipay.cat.response.CatFacts;
import org.chipay.cat.response.CatImagesURLResponse;
import org.chipay.cat.response.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
public class RestApiCatService implements CatService {

    @Autowired
    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getFact() {
        CatFacts catFacts = this.restTemplate.getForObject("http://catfacts-api.appspot.com/api/facts", CatFacts.class);
        if (!catFacts.isSuccess()) {
            throw new RuntimeException("Error response from catfacts-api");
        }
        List<String> facts = catFacts.getFacts();
        if (facts.isEmpty()) {
            throw new RuntimeException("No facts were returned by catfacts-apiappspot.com");
        }
        return facts.get(0);
    }

    @Override
    public URL getImageURL() throws MalformedURLException {
        CatImagesURLResponse urlImagesResponse = this.restTemplate.getForObject(
                "http://thecatapi.com/api/images/get?format=xml",
                CatImagesURLResponse.class
        );

        List<Image> images = urlImagesResponse.getData().getImages();
        if (images.isEmpty()) {
            throw new RuntimeException("No images were returned by thecatapi.com");
        }
        return new URL(images.get(0).getUrl());
    }
}

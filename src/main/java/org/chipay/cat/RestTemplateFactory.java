package org.chipay.cat;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestTemplateFactory {

    public static RestTemplate create() {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_XML);
        mediaTypes.add(new MediaType("application", "javascript"));
        converter.setSupportedMediaTypes(mediaTypes);
        restTemplate.getMessageConverters().add(converter);

        return restTemplate;
    }

}

package org.chipay.cat;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class RestTemplateFactory {

    public static RestTemplate create() {
        RestTemplate restTemplate = new RestTemplate();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(
                Collections.singletonList(new MediaType("application", "javascript"))
        );
        restTemplate.getMessageConverters().add(converter);

        return restTemplate;
    }

}

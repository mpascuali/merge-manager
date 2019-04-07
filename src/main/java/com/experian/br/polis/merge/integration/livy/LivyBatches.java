package com.experian.br.polis.merge.integration.livy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



import java.util.Arrays;


@Component
public class LivyBatches {

    @Value("${requested.by}")
    private String user;

    @Value("${authorization}")
    private String authorization;

    public Integer getBatches(String cluster)
    {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization",authorization);
        headers.set("X-Requested-By", user);
        HttpEntity<Body> entity = new HttpEntity<Body>(null, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Batches> respEntity = restTemplate.exchange(cluster, HttpMethod.GET, entity, Batches.class);
        return respEntity.getBody().getTotal();

    }
}

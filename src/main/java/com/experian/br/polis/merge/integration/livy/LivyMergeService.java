package com.experian.br.polis.merge.integration.livy;

import com.experian.br.polis.merge.model.MergeResponse;
import com.experian.br.polis.merge.service.MergeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

@Component
class LivyMergeService implements MergeService {
    @Value("${livy.url}")
    private String url;

    @Value("${requested.by}")
    private String user;

    @Value("${authorization}")
    private String authorization;

    @Value("${file.location}")
    private String file;

    @Value("${class.name}")
    private String className;

    public MergeResponse merge(String customerBase) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);


        Body body = new Body();
        body.setFile("s3://serasa-polis/merge2.0.jar");
        body.setClassName("sort.Merge");
        body.setExecutorCores(1);
        body.setExecutorMemory("5G");
        body.setNumExecutors(10);
        body.setName("LivyREST");
        body.setProxyUser("hadooop");
        String baseSerasaNova = "s3://serasa-polis/saida.txt.743a2daa-b1d8-4f90-a6d0-ef68329e791d";
        String baseSerasa = "s3://serasa-polis/base-50gb.csv";
        String saida = "s3://serasa-polis/saida.txt." + UUID.randomUUID().toString();
        String parameters[] = {"yarn", baseSerasa, baseSerasaNova, saida};
        body.setArgs(parameters);

        HttpEntity<Body> entity = new HttpEntity<Body>(body, headers);
        ResponseEntity<Response> respEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Response.class);

        System.out.println("Job Id:" + respEntity.getBody().getId());
        System.out.println("Saida: " + saida);
        return MergeResponse.builder().status(respEntity.getBody().getState()).build();
    }
}

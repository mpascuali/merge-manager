package com.experian.br.polis.merge;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Track {

    @Value("${requested.by}")
    private String user;

    @Value("${authorization}")
    private String authorization;

    @Value("${livy.url}")
    private String url;

    public void trackJob(String jobId)  throws InterruptedException  {
//        RestTemplate restTemplate = new RestTemplate();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization",authorization);
//        headers.set("X-Requested-By", user);
//
//        HttpEntity<Body> entity = new HttpEntity<Body>(headers);
//
//        //while (!(respEntity.getBody().getState().equals("dead")))
//        while (1==1)
//        {
//            ResponseEntity<State> respEntity = restTemplate.exchange(url+"/"+jobId+"/state", HttpMethod.GET, entity, State.class);
//            System.out.println(respEntity.getBody().getState());
//            Thread.sleep(10000);
//        }
    }
}

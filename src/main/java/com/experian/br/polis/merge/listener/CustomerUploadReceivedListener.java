package com.experian.br.polis.merge.listener;

import com.experian.br.polis.merge.model.MergeResponse;
import com.experian.br.polis.merge.service.MergeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class CustomerUploadReceivedListener {

    private final MergeService mergeService;

    @Autowired
    public CustomerUploadReceivedListener(MergeService mergeService) {
        this.mergeService = mergeService;
    }

    @RabbitListener(queues = "event.upload.validated")
    public void merge(@Payload String file) {
        MergeResponse response = mergeService.merge(file);
        System.out.println(response);
    }
}

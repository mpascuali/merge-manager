package com.experian.br.polis.merge.listener;

import com.experian.br.polis.merge.listener.messages.EventClusterMessage;
import com.experian.br.polis.merge.listener.messages.EventUploadReceivedMessage;
import com.experian.br.polis.merge.model.ClusterInfo;
import com.experian.br.polis.merge.model.MergeFile;
import com.experian.br.polis.merge.service.LoadBalancerService;
import com.experian.br.polis.merge.service.MergeQueueService;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomerUploadReceivedListener {

    private MergeQueueService mergeQueueService;
    private LoadBalancerService loadBalancerService;

    @Autowired
    public CustomerUploadReceivedListener(MergeQueueService mergeQueueService, LoadBalancerService loadBalancerService) {
        this.mergeQueueService = mergeQueueService;
        this.loadBalancerService = loadBalancerService;
    }

    @RabbitListener(queues = "event.upload.validated")
    public void merge(@Payload EventUploadReceivedMessage eventUploadReceivedMessage, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        mergeQueueService.queue(new MergeFile(eventUploadReceivedMessage.getFile(), eventUploadReceivedMessage.getCompany()));
    }

    @RabbitListener(queues = "event.cluster.added")
    public void addCluster(@Payload EventClusterMessage eventClusterMessage) {
        loadBalancerService.addCluster(
                ClusterInfo.builder()
                        .name(eventClusterMessage.getName())
                        .url(eventClusterMessage.getUrl())
                        .company(eventClusterMessage.getCompany())
                        .build()
        );

    }

    @RabbitListener(queues = "event.cluster.removed")
    public void removeCluster(@Payload EventClusterMessage eventClusterMessage) {
        loadBalancerService.removeCluster(eventClusterMessage.getName());
    }
}

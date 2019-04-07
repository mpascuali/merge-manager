package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.model.MergeFile;
import com.experian.br.polis.merge.service.DispatcherService;
import com.experian.br.polis.merge.service.LoadBalancerService;
import com.experian.br.polis.merge.service.MergeQueueService;
import com.experian.br.polis.merge.service.NoResourceAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DispatcherServiceImpl implements DispatcherService, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private LoadBalancerService loadBalancerService;
    @Autowired
    private MergeQueueService mergeQueueService;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.process();
    }

    public void process() {
        while (true) {
            Optional<MergeFile> mergeFile = mergeQueueService.peek();
            if(mergeFile.isPresent()) {
                boolean completed = false;
                try {
                    loadBalancerService.execute(mergeFile.get());
                    completed = true;
                } catch (NoResourceAvailableException e) {
                    System.out.println("No resources available");
                    completed = false;
                } finally {
                    if (completed) mergeQueueService.remove(mergeFile.get());
                }
            }
            this.sleep(5000);

        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

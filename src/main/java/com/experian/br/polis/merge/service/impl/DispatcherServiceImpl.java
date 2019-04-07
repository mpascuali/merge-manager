package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.model.MergeFile;
import com.experian.br.polis.merge.service.DispatcherService;
import com.experian.br.polis.merge.service.MergeQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DispatcherServiceImpl implements DispatcherService, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private MergeQueueService mergeQueueService;
    @

    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.process();
    }

    public void process() {
        while (true) {
            Optional<MergeFile> mergeFile = mergeQueueService.peek();
        }
    }
}

package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.model.MergeFile;
import com.experian.br.polis.merge.service.DispatcherService;
import com.experian.br.polis.merge.service.LoadBalancerService;
import com.experian.br.polis.merge.service.NoResourceAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DispatcherServiceImpl implements DispatcherService, ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private LoadBalancerService loadBalancerService;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.process();
    }

    public void process() {
        while (true) {

            MergeFile mergeFile = null; //Buscar no servico

            if(mergeFile != null) {

                try {

                    this.loadBalancerService.execute(mergeFile);

                    //remover da fila

                } catch (NoResourceAvailableException e) {
                    e.printStackTrace();
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

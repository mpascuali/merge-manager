package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.service.DispatcherService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DispatcherServiceImpl implements DispatcherService, ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.process();
    }

    public void process() {
        while (true) {

            
            System.out.println("TESTE");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

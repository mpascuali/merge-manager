package com.experian.br.polis.merge.integration.livy;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
class Body {
    private String file;
    private String name;
    private String proxyUser;
    private String executorMemory;
    private int numExecutors;
    private int executorCores;
    private String className;
    private String[] args;
}

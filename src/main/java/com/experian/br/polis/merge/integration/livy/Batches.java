package com.experian.br.polis.merge.integration.livy;

import lombok.Data;

@Data
public class Batches {

    private Integer from;

    private Integer total;

    Sessions[] sessions;

}

package com.experian.br.polis.merge.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClusterInfo {
    private String name;
    private String url;
    private String company;
}

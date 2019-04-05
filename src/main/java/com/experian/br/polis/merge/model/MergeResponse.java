package com.experian.br.polis.merge.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class MergeResponse {
    private final String status;
}

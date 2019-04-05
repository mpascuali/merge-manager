package com.experian.br.polis.merge.integration.livy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class State {
    @JsonProperty(value = "id")
    private String id = null;

    @JsonProperty(value = "state")
    private String state = null;

}

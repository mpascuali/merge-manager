package com.experian.br.polis.merge.integration.livy;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
class Response {
    @JsonProperty(value = "id")
    private String id = null;

    @JsonProperty(value = "state")
    private String state = null;

    @JsonProperty(value = "appId")
    private String appId = null;

    @JsonProperty(value = "appInfo")
    private Info info = null;

    @JsonProperty(value = "log")
    private String[] log = null;
}

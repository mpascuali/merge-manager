package com.experian.br.polis.merge.integration.livy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sessions {

    private Integer id;

    private String state;

    private String appId;

    @JsonProperty(value = "appInfo")
    private AppInfo appInfo;

    private String[] log;
}

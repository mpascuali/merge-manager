package com.experian.br.polis.merge.integration.livy;

import com.fasterxml.jackson.annotation.JsonProperty;

class Info {
    @JsonProperty(value = "driverLogUrl")
    private String driverLogUrl = null;

    @JsonProperty(value = "sparkUiUrl")
    private String sparkUiUrl = null;
}

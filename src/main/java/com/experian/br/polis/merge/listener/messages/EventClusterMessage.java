package com.experian.br.polis.merge.listener.messages;

import lombok.Data;

@Data
public class EventClusterMessage {
    private String name;
    private String url;
    private String company;
}

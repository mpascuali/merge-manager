package com.experian.br.polis.merge.listener.messages;

import lombok.Data;

@Data
public class EventUploadReceivedMessage {
    private String file;
    private String company;
}

package com.experian.br.polis.merge.model;

import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class MergeFile {
    private String id;
    private String file;
    private String company;

    public MergeFile(String file, String company) {
        this.file = file;
        this.id = UUID.randomUUID().toString();
    }
}

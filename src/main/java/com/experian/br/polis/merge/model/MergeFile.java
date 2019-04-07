package com.experian.br.polis.merge.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MergeFile mergeFile = (MergeFile) o;
        return Objects.equals(id, mergeFile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

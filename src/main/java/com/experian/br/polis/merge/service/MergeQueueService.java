package com.experian.br.polis.merge.service;

import com.experian.br.polis.merge.model.MergeFile;

import java.util.Optional;

public interface MergeQueueService {

    void queue(MergeFile mergeFile);
    Optional<MergeFile> peek();
    void remove(MergeFile mergeFile);
}

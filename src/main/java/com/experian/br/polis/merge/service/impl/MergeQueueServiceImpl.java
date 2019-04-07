package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.model.MergeFile;
import com.experian.br.polis.merge.service.MergeQueueService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

@Service
class MergeQueueServiceImpl implements MergeQueueService {

    private final Queue<MergeFile> queue;

    public MergeQueueServiceImpl() {
        queue = new LinkedBlockingDeque<>();
    }

    public void queue(MergeFile mergeFile) {
        queue.add(mergeFile);
    }

    @Override
    public Optional<MergeFile> peek() {
        return Optional.ofNullable(queue.peek());
    }

    @Override
    public void remove(MergeFile mergeFile) {
        MergeFile removed = queue.poll();
    }
}

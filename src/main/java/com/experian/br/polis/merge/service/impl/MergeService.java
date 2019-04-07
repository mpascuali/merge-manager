package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.model.MergeResponse;

public interface MergeService {
    MergeResponse merge(String customerBase, String cluster);
}

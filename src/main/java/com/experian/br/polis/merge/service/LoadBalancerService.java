package com.experian.br.polis.merge.service;

import com.experian.br.polis.merge.model.ClusterInfo;
import com.experian.br.polis.merge.model.MergeFile;

public interface LoadBalancerService {
    void execute(MergeFile mergeFile) throws NoResourceAvailableException;
    void addCluster(ClusterInfo cluster);
    void removeCluster(String clusterName);
}

package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.model.ClusterInfo;
import com.experian.br.polis.merge.model.MergeFile;
import com.experian.br.polis.merge.service.LoadBalancerService;
import com.experian.br.polis.merge.service.NoResourceAvailableException;
import com.sun.xml.internal.ws.developer.Serialization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {
    @Override
    public void execute(MergeFile mergeFile) throws NoResourceAvailableException {

    }

    @Override
    public void addCluster(ClusterInfo cluster) {

    }

    @Override
    public void removeCluster(String clusterName) {

    }
}

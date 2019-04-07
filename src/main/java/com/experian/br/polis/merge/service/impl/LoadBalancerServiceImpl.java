package com.experian.br.polis.merge.service.impl;

import com.experian.br.polis.merge.integration.livy.LivyBatches;
import com.experian.br.polis.merge.integration.livy.LivyMergeService;
import com.experian.br.polis.merge.model.ClusterInfo;
import com.experian.br.polis.merge.model.MergeFile;
import com.experian.br.polis.merge.service.LoadBalancerService;
import com.experian.br.polis.merge.service.NoResourceAvailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class LoadBalancerServiceImpl implements LoadBalancerService {

    @Autowired
    private List<ClusterInfo> generalCluster;


    @Autowired
    private LivyBatches livyBatches;

    @Autowired
    private LivyMergeService livyMergeService;

    @Value("${livy.maxnumber.clusters}")
    private int maxNumberClusters;


    public void addCluster(ClusterInfo cluster)
    {
        generalCluster.add(cluster);
    }

    public void removeCluster(ClusterInfo cluster)
    {
        generalCluster.remove(cluster);
    }


    public void execute(final MergeFile mergeFile) throws NoResourceAvailableException {

        //ownCluster= generalCluster.stream().filter(server -> server.getCompany()==mergeFile.getCompany()).collect(Collectors.toList());
        //humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
        //Collections.sort(personList, (p1, p2) -> p1.firstName.compareTo(p2.firstName));
        //generalCluster.stream().sorted(cluster -> cluster.getCompany().compareTo(mergeFile.getCompany()));
        //marketDataList.getMarketDataList().sort(Comparator.comparing(MarketData::getCommodityID).thenComparing(Comparator.comparing(MarketData::getStockExchange)).thenComparing(Comparator.comparing(MarketData::getOrder)));
//1 == 1 ? "Verdadeiro" : "False"
        //generalCluster.sort(Comparator.comparing(ClusterInfo::getCompany.equals(mergeFile.getCompany())?0:1));

        for (ClusterInfo cl : generalCluster)
        {
            if ((cl.getCompany() == null)||(cl.getCompany().equals(mergeFile.getCompany())) && (livyBatches.getBatches(cl.getName())<maxNumberClusters))
            {
                livyMergeService.merge(mergeFile.getFile(),cl.getUrl());
                return;
            }
        }

        throw new NoResourceAvailableException();

    }
}

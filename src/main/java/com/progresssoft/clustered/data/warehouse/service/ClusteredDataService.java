package com.progresssoft.clustered.data.warehouse.service;

import java.util.Set;

import com.progresssoft.clustered.data.warehouse.model.ClusteredDataModel;

public interface ClusteredDataService {	
	public void add(ClusteredDataModel clusteredDataModel);
    public void addAll(Set<ClusteredDataModel> list);
}

package com.eureka.a.service;

import com.eureka.a.model.ASignalModel;

import java.util.List;

public interface ASignalService {

    ASignalModel getDataById(long id);

    List<ASignalModel> getData(int startIndex, int endIndex);

    List<ASignalModel> getDataPage(int pageNum, int pageSize);

}

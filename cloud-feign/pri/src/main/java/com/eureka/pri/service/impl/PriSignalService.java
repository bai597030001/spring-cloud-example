package com.eureka.pri.service.impl;

import com.eureka.pri.model.PriSignalModel;

import java.util.List;

public interface PriSignalService {

    PriSignalModel getDataById(long id);

    List<PriSignalModel> getData(int startIndex, int endIndex);

    List<PriSignalModel> getPriDataPage(int pageNum, int pageSize);

}

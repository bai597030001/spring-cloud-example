package com.eureka.a.service.impl;

import com.eureka.a.dao.ASignalDao;
import com.eureka.a.model.ASignalModel;
import com.eureka.a.service.ASignalService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ASignalServiceImpl implements ASignalService {

    @Resource
    private ASignalDao aSignalDao;

    @Override
    public ASignalModel getDataById(long id) {
        return aSignalDao.getDataById(id);
    }

    @Override
    public List<ASignalModel> getData(int startIndex, int endIndex) {
        return aSignalDao.getData(startIndex, endIndex);
    }

    @Override
    public List<ASignalModel> getDataPage(int pageNum, int pageSize) {
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,
        // 否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(pageNum, pageSize);
        List<ASignalModel> dataPage = aSignalDao.getDataPage();
        System.out.println(dataPage);
        return dataPage;
    }
}

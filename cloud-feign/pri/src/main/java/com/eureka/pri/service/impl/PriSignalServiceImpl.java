package com.eureka.pri.service.impl;

import com.eureka.pri.dao.PriSignalDao;
import com.eureka.pri.model.PriSignalModel;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PriSignalServiceImpl implements PriSignalService {

    @Resource
    private PriSignalDao priSignalDao;

    @Override
    public PriSignalModel getDataById(long id) {
        return priSignalDao.getDataById(id);
    }

    @Override
    public List<PriSignalModel> getData(int startIndex, int endIndex) {
        return priSignalDao.getData(startIndex, endIndex);
    }

    @Override
    public List<PriSignalModel> getPriDataPage(int pageNum, int pageSize) {
        //利用PageHelper分页查询 注意：这个一定要放查询语句的前一行,
        // 否则无法进行分页,因为它对紧随其后第一个sql语句有效
        PageHelper.startPage(pageNum, pageSize);
        List<PriSignalModel> dataPage = priSignalDao.getDataPage();
        System.out.println(dataPage);
        return dataPage;
    }
}

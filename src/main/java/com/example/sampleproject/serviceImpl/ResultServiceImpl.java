package com.example.sampleproject.serviceImpl;

import com.example.sampleproject.database.DataBase;
import com.example.sampleproject.entity.ResultEntity;
import com.example.sampleproject.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {

    private DataBase dataBase;

    @Autowired
    public ResultServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public List<ResultEntity> fetchAllResult() {
        return dataBase.getResultEntityList();
    }
}

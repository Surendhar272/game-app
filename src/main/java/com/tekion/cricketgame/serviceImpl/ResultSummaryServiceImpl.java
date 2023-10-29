package com.tekion.cricketgame.serviceImpl;

import com.tekion.cricketgame.repository.ResultSummaryRepository;
import com.tekion.cricketgame.service.ResultSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultSummaryServiceImpl implements ResultSummaryService {

    private final ResultSummaryRepository resultSummaryRepository;

    @Autowired
    public ResultSummaryServiceImpl(ResultSummaryRepository resultSummaryRepository) {
        this.resultSummaryRepository = resultSummaryRepository;
    }

}

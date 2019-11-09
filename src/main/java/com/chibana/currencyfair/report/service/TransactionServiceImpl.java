package com.chibana.currencyfair.report.service;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Rodrigo Chibana
 * Date: 09/11/2019
 **/
@Service
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Page<TransactionDateResponse> getTransactionsByDate(Date initDate, Date endDate) {
        return null;
    }

}

package com.chibana.currencyfair.report.service;

import com.chibana.currencyfair.report.client.TransactionClientImpl;
import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import com.chibana.currencyfair.report.page.TransactionPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Rodrigo Chibana
 * Date: 09/11/2019
 **/
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionClientImpl transactionClient;
    private final SimpleDateFormat sdf;

    @Autowired
    public TransactionServiceImpl(TransactionClientImpl transactionClient) {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.transactionClient = transactionClient;
    }

    @Override
    public Page<TransactionDateResponse> getTransactionsByDate(final Date initDate, final Date endDate, final PageRequest pageRequest) throws JsonProcessingException {

        final String initDateString = sdf.format(initDate);
        final String endDateString = sdf.format(endDate);

        return transactionClient.getTransactionsByDate(initDateString, endDateString, pageRequest.getPageNumber(),
                pageRequest.getPageSize());

    }

}

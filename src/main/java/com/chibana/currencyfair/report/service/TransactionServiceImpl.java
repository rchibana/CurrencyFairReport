package com.chibana.currencyfair.report.service;

import com.chibana.currencyfair.report.client.TransactionClientImpl;
import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class TransactionServiceImpl implements TransactionService {

    private final TransactionClientImpl transactionClient;
    private final SimpleDateFormat sdf;

    @Autowired
    public TransactionServiceImpl(TransactionClientImpl transactionClient) {
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.transactionClient = transactionClient;
    }

    @Override
    public Page<TransactionDateResponse> getTransactionsByDate(final Date initDate, final Date endDate, final PageRequest pageRequest) {

        log.info("initDate={}, endDate={}", initDate, endDate);

        final String initDateString = sdf.format(initDate);
        final String endDateString = sdf.format(endDate);

        log.info("initDateFormatted={}, endDateFormatted={}", initDateString, endDateString);

        return transactionClient.getTransactionsByDate(initDateString, endDateString, pageRequest.getPageNumber(),
                pageRequest.getPageSize());

    }

}

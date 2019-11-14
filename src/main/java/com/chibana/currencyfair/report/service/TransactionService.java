package com.chibana.currencyfair.report.service;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

/**
 * Created by Rodrigo Chibana
 * Date: 09/11/2019
 **/
public interface TransactionService {

    Page<TransactionDateResponse> getTransactionsByDate(Date initDate, Date endDate, PageRequest pageRequest) throws JsonProcessingException;

}

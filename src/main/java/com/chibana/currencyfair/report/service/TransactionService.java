package com.chibana.currencyfair.report.service;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import org.springframework.data.domain.Page;

import java.util.Date;

/**
 * Created by Rodrigo Chibana
 * Date: 09/11/2019
 **/
public interface TransactionService {

    Page<TransactionDateResponse> getTransactionsByDate(Date initDate, Date endDate);

}

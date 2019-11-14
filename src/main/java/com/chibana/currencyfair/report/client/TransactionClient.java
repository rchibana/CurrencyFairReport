package com.chibana.currencyfair.report.client;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.data.domain.Page;

/**
 * Created by Rodrigo Chibana
 * Date: 13/11/2019
 **/
public interface TransactionClient {

    Page<TransactionDateResponse> getTransactionsByDate(final String initDate, final String endDate, final Integer pageNumber, final Integer pageSize) throws JsonProcessingException;

}

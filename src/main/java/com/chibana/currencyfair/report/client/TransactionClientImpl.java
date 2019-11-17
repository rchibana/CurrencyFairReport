package com.chibana.currencyfair.report.client;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import com.chibana.currencyfair.report.page.TransactionPage;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by Rodrigo Chibana
 * Date: 13/11/2019
 **/
@Component
@Log4j2
public class TransactionClientImpl implements TransactionClient {

    private static final String INIT_DATE = "initDate";
    private static final String END_DATE = "endDate";
    private static final String PAGE_NUMBER = "pageNumber";
    private static final String PAGE_SIZE = "pageSize";

    private final RestTemplate restTemplate;

    @Value("${api.transaction.url}")
    private String urlTransactionApi;

    public TransactionClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    @Cacheable("transactionsByDate")
    public Page<TransactionDateResponse> getTransactionsByDate(final String initDate, final String endDate,
                                                               final Integer pageNumber, final Integer pageSize) {

        log.info("initDate={}, endDate={}", initDate, endDate);

        final URI uri = UriComponentsBuilder.fromUriString(urlTransactionApi + "/transaction/reporter/date")
                .queryParam(INIT_DATE, initDate)
                .queryParam(END_DATE, endDate)
                .queryParam(PAGE_NUMBER, String.valueOf(pageNumber))
                .queryParam(PAGE_SIZE, String.valueOf(pageSize))
                .build()
                .toUri();

        final ParameterizedTypeReference<TransactionPage<TransactionDateResponse>> responseType;
        responseType = new ParameterizedTypeReference<TransactionPage<TransactionDateResponse>>() {};

        final ResponseEntity<TransactionPage<TransactionDateResponse>> responseEntity;
        responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, responseType);

        if(responseEntity.getBody() != null && responseEntity.getBody().getTotalElements() > 0) {
            return responseEntity.getBody();
        }

        log.info("No body received");

        return new TransactionPage<>();

    }

}

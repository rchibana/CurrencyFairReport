package com.chibana.currencyfair.report.client;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import com.chibana.currencyfair.report.page.TransactionPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
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
public class TransactionClientImpl implements TransactionClient {

    private static final String INIT_DATE = "initDate";
    private static final String END_DATE = "endDate";
    private static final String PAGE_NUMBER = "pageNumber";
    private static final String PAGE_SIZE = "pageSize";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${api.transaction.url}")
    private String URL;

    public TransactionClientImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        this.restTemplate = new RestTemplate();
    }

    @Override
    public TransactionPage<TransactionDateResponse> getTransactionsByDate(final String initDate, final String endDate, final Integer pageNumber, final Integer pageSize) throws JsonProcessingException {

        final URI uri = UriComponentsBuilder.fromUriString(URL + "/transaction/reporter/date")
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

        if(responseEntity.getBody() != null && responseEntity.getBody().getTotalElements() > 0){
            final String responseAsString = String.valueOf(responseEntity.getBody().getContent());
            return objectMapper.readValue(responseAsString, new TypeReference<TransactionPage<TransactionDateResponse>>() {});
        }

        return new TransactionPage<>();

    }

}

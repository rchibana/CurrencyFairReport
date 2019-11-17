package com.chibana.currencyfair.report.client;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import com.chibana.currencyfair.report.page.TransactionPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Rodrigo Chibana
 * Date: 17/11/2019
 **/
class TransactionClientImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private TransactionClientImpl transactionClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(transactionClient, "urlTransactionApi", "http://localhost:8080");
    }

    @Test
    void getTransactionsByDateReturnsNoContent() {
        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(RequestEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(null);

        Page<TransactionDateResponse> transactionsByDate = transactionClient.getTransactionsByDate("17/11/2019",
                "20/11/2019", 0, 10);

        Assertions.assertFalse(transactionsByDate.hasContent());

    }

    @Test
    void getTransactionsByDateReturnsNoBody() {

        final ResponseEntity responseEntityMock = mock(ResponseEntity.class);
        when(responseEntityMock.getBody()).thenReturn(null);

        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(RequestEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(responseEntityMock);

        Page<TransactionDateResponse> transactionsByDate = transactionClient.getTransactionsByDate("17/11/2019",
                "20/11/2019", 0, 10);

        Assertions.assertFalse(transactionsByDate.hasContent());

    }

    @Test
    void getTransactionsByDateReturnsEmptyList() {

        final ResponseEntity<TransactionPage<TransactionDateResponse>> responseEntityMock = mock(ResponseEntity.class);
        when(responseEntityMock.getBody()).thenReturn(new TransactionPage<>());

        when(restTemplate.exchange(any(URI.class), any(HttpMethod.class), any(RequestEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(responseEntityMock);

        Page<TransactionDateResponse> transactionsByDate = transactionClient.getTransactionsByDate("17/11/2019",
                "20/11/2019", 0, 10);

        Assertions.assertFalse(transactionsByDate.hasContent());

    }
}
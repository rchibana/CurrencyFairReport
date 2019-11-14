package com.chibana.currencyfair.report.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Rodrigo Chibana
 * Date: 09/11/2019
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDateResponse {

    private Long id;

    private Long userId;

    private String currencyFrom;

    private String currencyTo;

    private BigDecimal amountSell;

    private BigDecimal amountBuy;

    private Double rate;

    @JsonFormat(pattern="dd-MMM-yy HH:mm:ss")
    private Date timePlaced;

    private String originatingCountry;

}

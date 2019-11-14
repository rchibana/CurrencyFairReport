package com.chibana.currencyfair.report.page;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rodrigo Chibana
 * Date: 13/11/2019
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionPage<T> extends PageImpl<T> {

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TransactionPage(@JsonProperty("content") List<T> content,
                           @JsonProperty("number") int number,
                           @JsonProperty("size") int size,
                           @JsonProperty("totalElements") Long totalElements,
                           @JsonProperty("pageable") JsonNode pageable,
                           @JsonProperty("last") boolean last,
                           @JsonProperty("totalPages") int totalPages,
                           @JsonProperty("sort") JsonNode sort,
                           @JsonProperty("first") boolean first,
                           @JsonProperty("numberOfElements") int numberOfElements) {
        super(content, new PageRequest(number, size), totalElements);
    }

    public TransactionPage(List content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public TransactionPage(List content) {
        super(content);
    }

    public TransactionPage() {
        super(new ArrayList<T>());
    }
}

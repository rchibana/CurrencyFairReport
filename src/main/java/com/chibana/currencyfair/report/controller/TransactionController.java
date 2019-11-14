package com.chibana.currencyfair.report.controller;

import com.chibana.currencyfair.report.dto.TransactionDateResponse;
import com.chibana.currencyfair.report.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Rodrigo Chibana
 * Date: 09/11/2019
 **/
@Controller
@RequestMapping("/transactions")
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public String getTransactions(@RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size,
                                  Model model) throws JsonProcessingException {

        final Calendar instance = Calendar.getInstance();
        final Date endDate = instance.getTime();

        instance.add(Calendar.DATE, -7);
        final Date initDate = instance.getTime();

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        final PageRequest pageRequest = new PageRequest(currentPage - 1, pageSize);

        final Page<TransactionDateResponse> transactionsByDate = transactionService.getTransactionsByDate(initDate, endDate, pageRequest);

        model.addAttribute("transactionsPage", transactionsByDate);

        int totalPages = transactionsByDate.getTotalPages();

        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "transactions";
    }

}

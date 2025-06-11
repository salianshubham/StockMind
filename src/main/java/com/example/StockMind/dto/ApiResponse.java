package com.example.StockMind.dto;

import lombok.Data;

@Data
public class ApiResponse <T>{

    private String status;
    private String successMessage;
    private T data;
}

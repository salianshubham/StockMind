package com.example.StockMind.util;

import com.example.StockMind.dto.ApiResponse;

public class ResponseUtil {

    public static <T> ApiResponse<T> success(String message, T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus("success");
        response.setSuccessMessage(message);
        response.setData(data);
        return response;
    }
}

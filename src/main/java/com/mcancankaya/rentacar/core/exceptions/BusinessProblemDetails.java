package com.mcancankaya.rentacar.core.exceptions;

public class BusinessProblemDetails extends ProblemDetails {
    public BusinessProblemDetails() {
        setTitle("Business Rule Violation");
        setStatus("500");
    }
}

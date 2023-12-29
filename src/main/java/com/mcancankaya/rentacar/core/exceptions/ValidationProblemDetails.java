package com.mcancankaya.rentacar.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationProblemDetails extends ProblemDetails {
    public ValidationProblemDetails() {
        setTitle("Validation Rule Violation");
        setDetail("Validation Problem");
        setStatus(HttpStatus.BAD_REQUEST.toString());
    }

    private Map<String, String> errors;
}

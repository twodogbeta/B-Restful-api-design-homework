package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonError {
    private Integer code;
    private String message;
}
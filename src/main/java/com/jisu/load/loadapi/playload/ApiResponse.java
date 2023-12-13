package com.jisu.load.loadapi.playload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse {

    private String msg;
    private boolean success;
    private HttpStatus status;

}

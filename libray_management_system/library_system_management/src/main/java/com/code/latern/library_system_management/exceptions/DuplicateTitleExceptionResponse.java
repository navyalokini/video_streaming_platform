package com.code.latern.library_system_management.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DuplicateTitleExceptionResponse {
    private String cause;
    private String message;
    private String statusCode;

}

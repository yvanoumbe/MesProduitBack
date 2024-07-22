package com.yvan.users.service.exceptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDetails {
	 private LocalDateTime timestamp;
	 private String message;
	 private String path;
	 private String errorCode;

}

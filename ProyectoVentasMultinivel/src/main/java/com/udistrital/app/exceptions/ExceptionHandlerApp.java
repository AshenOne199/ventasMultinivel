package com.udistrital.app.exceptions;

import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.udistrital.app.exceptions.Constants.*;

@ControllerAdvice
public class ExceptionHandlerApp extends ResponseEntityExceptionHandler{

	@ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String, String>> handleSQLException(SQLException ex) {

		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getLocalizedMessage());
		map.put("code", String.valueOf(ex.getErrorCode()));
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }

	@ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDataAccessException(DataAccessException ex) {
        // Aquí puedes personalizar la respuesta de error según tus necesidades
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error de acceso a datos en la base de datos | " + ex.getMessage());
    }

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Map<String, String>> handleSQLException(NotFoundException ex) {

		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getLocalizedMessage());
		map.put("code", String.valueOf(0));
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }

	@ExceptionHandler(NoFoundInventraioException.class)
	public ResponseEntity<Map<String, String>> handleNoFoundInventraioException(
			NoFoundInventraioException noFoundInventraioException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, INVENTARIO_NOT_FOUND_MESSAGE));
	}
	@ExceptionHandler(NoFoundClientException.class)
	public ResponseEntity<Map<String, String>> handleNoFoundClientException(
			NoFoundClientException noFoundClientException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CLIENT_NOT_FOUND_MESSAGE));
	}

	@ExceptionHandler(NoFoundPeriodException.class)
	public ResponseEntity<Map<String, String>> handleNoFoundPeriodException(
			NoFoundPeriodException noFoundPeriodException) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, PERIOD_NOT_FOUND_MESSAGE));
	}
}

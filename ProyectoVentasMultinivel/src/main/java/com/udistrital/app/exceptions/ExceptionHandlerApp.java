package com.udistrital.app.exceptions;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerApp extends ResponseEntityExceptionHandler{

	@ExceptionHandler(SQLException.class)
    public ResponseEntity<Map<String, String>> handleSQLException(SQLException ex) {

		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("code", String.valueOf(ex.getErrorCode()));
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.INTERNAL_SERVER_ERROR);

    }

	@ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDataAccessException(DataAccessException ex) {
        // Aquí puedes personalizar la respuesta de error según tus necesidades
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error de acceso a datos en la base de datos | " + ex.getMessage());
    }
	
}

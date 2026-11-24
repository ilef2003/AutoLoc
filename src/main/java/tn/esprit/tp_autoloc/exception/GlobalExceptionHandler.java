package tn.esprit.tp_autoloc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String STATUT = "statut";
    private static final String MESSAGE = "message";
    private static final String HORODATAGE = "horodatage";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of(
                STATUT, 404,
                MESSAGE, ex.getMessage(),
                HORODATAGE, LocalDateTime.now().toString()
        ));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of(
                STATUT, 400,
                MESSAGE, ex.getMessage(),
                HORODATAGE, LocalDateTime.now().toString()
        ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> erreurs = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(e ->
                erreurs.put(e.getField(), e.getDefaultMessage()));

        return ResponseEntity.badRequest().body(Map.of(
                STATUT, 400,
                MESSAGE, "Erreur de validation",
                "erreurs", erreurs,
                HORODATAGE, LocalDateTime.now().toString()
        ));
    }
}
package co.edu.uniandes.dse.parcialprueba.exceptions;

public class ErrorMessage {
    public static final String CANCION_NOT_FOUND = "Cancion no encontrada.";
    public static final String INTERPRETE_NOT_FOUND = "Interprete no encontrado.";
    private ErrorMessage() {
		throw new IllegalStateException("Utility class");
}}



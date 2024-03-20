package com.api.apirest.exceptions;

import org.springframework.http.HttpStatus;

public class BlogAppException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private HttpStatus estado;
    private String mensaje;

    public BlogAppException(HttpStatus estado, String mensaje) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public BlogAppException(HttpStatus estado, String mensaje,String mensaje1) {
        super();
        this.estado = estado;
        this.mensaje = mensaje;
        this.mensaje= mensaje1;
    }

    public BlogAppException(String message, HttpStatus estado, String mensaje) {
        super(message);
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public BlogAppException(String message, Throwable cause, HttpStatus estado, String mensaje) {
        super(message, cause);
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public BlogAppException(Throwable cause, HttpStatus estado, String mensaje) {
        super(cause);
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public BlogAppException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus estado, String mensaje) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.estado = estado;
        this.mensaje = mensaje;
    }
}

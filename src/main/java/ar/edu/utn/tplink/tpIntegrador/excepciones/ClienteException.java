package ar.edu.utn.tplink.tpIntegrador.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

 @ResponseStatus(HttpStatus.BAD_REQUEST)
 class ClienteException extends RuntimeException{
    
 }


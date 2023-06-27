package com.example.Licensing.ReponseMessage;

import org.springframework.http.HttpStatus;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

public class ResponseMessage<T> {
    private String message;
    private HttpStatus statusCode;
    private T data;

    public ResponseMessage(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public ResponseMessage(HttpStatus statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public ResponseMessage(HttpStatus statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public ResponseMessage() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
package fr.demos.septemearchebackend.exceptions;



public record ApiError(int code,String message) {

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}


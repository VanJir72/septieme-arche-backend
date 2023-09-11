package fr.demos.septemearchebackend.exceptions;

public class AuthorNotFoundException extends NotFoundException{
    public AuthorNotFoundException(String message) {
        super(message);
    }
}

package fr.demos.septemearchebackend.exceptions;

public class CommandeNotFoundException extends NotFoundException{
    public CommandeNotFoundException(String message) {
        super(message);
    }
}

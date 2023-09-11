package fr.demos.septemearchebackend.exceptions;

public class AddressNotFoundException extends NotFoundException{
    public AddressNotFoundException(String message) {
        super(message);
    }
}

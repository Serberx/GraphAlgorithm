package at.kuzu.graphprogram.exception;

public class PersisterException extends Exception{
    public PersisterException(String message){
        super(message);
    }
    public PersisterException(String message, Throwable cause){
        super(message, cause);
    }
}

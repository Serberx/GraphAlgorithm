package exception;

public class GraphenException extends Exception{

    public GraphenException(String message){
        super(message);
    }
    public GraphenException(String message, Throwable cause){
        super(message, cause);
    }
}

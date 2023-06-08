package ReponseMessage;

public class ResponseMessage {
    public String message;

    //poja : plain old java object
    public void ResponseMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

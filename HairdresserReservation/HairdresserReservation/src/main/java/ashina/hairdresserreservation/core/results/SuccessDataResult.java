package ashina.hairdresserreservation.core.results;

public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult(String message, T data) {
        super(data, true, message);
    }

    public SuccessDataResult(T data){
        super(true, data);
    }

    public SuccessDataResult(String message){
        super(null, true, message);
    }

    public SuccessDataResult(){
        super(true, null);
    }

}

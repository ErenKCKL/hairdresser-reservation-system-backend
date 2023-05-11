package ashina.hairdresserreservation.core.results;

public class ErrorDataResult<T> extends DataResult<T>{
    public ErrorDataResult(String message, T data) {
        super(data, false, message);
    }

    public ErrorDataResult(T data){
        super(false, data);
    }

    public ErrorDataResult(String message){
        super(null, false, message);
    }

    public ErrorDataResult(){
        super(false, null);
    }

}

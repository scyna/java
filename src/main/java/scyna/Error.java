package scyna;

public class Error extends java.lang.Exception {
    int code;
    String message;

    public static final Error OK = New(0, "Success");
    public static final Error SERVER_ERROR = New(1, "Server Error");
    public static final Error BAD_REQUEST = New(2, "Bad Request");
    public static final Error PERMISSION_ERROR = New(4, "Permission Error");
    public static final Error REQUEST_INVALID = New(5, "Request Invalid");
    public static final Error MODULE_NOT_EXIST = New(6, "Module Not Exist");
    public static final Error BAD_DATA = New(7, "Bad Data");
    public static final Error STREAM_ERROR = New(8, "Stream Error");

    private Error(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public static Error New(int code, String message) {
        return new Error(code, message);
    }

    public scyna.proto.Error toProto() {
        return scyna.proto.Error.newBuilder().setCode(code).setMessage(message).build();
    }
}

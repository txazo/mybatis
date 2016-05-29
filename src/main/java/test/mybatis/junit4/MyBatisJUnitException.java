package test.mybatis.junit4;

public class MyBatisJUnitException extends RuntimeException {

    private static final long serialVersionUID = -5630798374804543041L;

    public MyBatisJUnitException() {
        super();
    }

    public MyBatisJUnitException(String message) {
        super(message);
    }

    public MyBatisJUnitException(Throwable cause) {
        super(cause);
    }

    public MyBatisJUnitException(String message, Throwable cause) {
        super(message, cause);
    }

}

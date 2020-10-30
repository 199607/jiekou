package com.nufe.grain.bean;

public class Result {

    private int success;

    private Object data;

    public static int SUCCESS=1;
    public static int ERROR=0;
    public int getSuccess() {
        return success;
    }

    public Object getData() {
        return data;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Result() {
        this.success=SUCCESS;
    }

    public Result(int success, Object data) {
        this.success = success;
        this.data = data;
    }

    public Result(int success) {
        this.success = success;
    }
}

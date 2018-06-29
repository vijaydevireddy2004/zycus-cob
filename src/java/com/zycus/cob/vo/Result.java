package com.zycus.cob.vo;

import java.io.Serializable;

public class Result implements Serializable{
    String errorCode, error, field;

    public Result(String errorCode, String error, String field) {
        this.errorCode = errorCode;
        this.error = error;
        this.field = field;
    }

    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
    
    
}

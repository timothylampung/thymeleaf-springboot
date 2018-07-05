package com.internbacked.internbacked.response.domain.model;

public class ResponseImpl implements Response {

    private String message;
    private boolean success;


    protected ResponseImpl() {
    }

    public ResponseImpl(String message, boolean success) {
        this.message = message;
        this.success = success;
    }


    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setSuccess(boolean success) {
        this.success =success;
    }

    @Override
    public boolean getSuccess() {
        return this.success;
    }
}

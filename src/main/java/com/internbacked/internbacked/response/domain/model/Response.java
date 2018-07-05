package com.internbacked.internbacked.response.domain.model;

public interface Response {

    void setMessage(String  message);
    String getMessage();

    void setSuccess(boolean success);
    boolean getSuccess();

}

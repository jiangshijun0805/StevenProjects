package com.xiaojiang.freamwork.validator;

public class ValidateResult {
    private Boolean isValid;
    
    private String message;
    
    public ValidateResult() {
        this.isValid = true;
    }
    
    public Boolean getIsValid() {
        return isValid;
    }
    
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
}

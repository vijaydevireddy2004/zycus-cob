package com.zycus.cob.mock;

public class CustomerUploadHandler {
    
    public com.zycus.cob.vo.Error upload(String excelFile){
        if (excelFile.trim().equalsIgnoreCase("") || excelFile == null) {
            return new com.zycus.cob.vo.Error("1","Customer first name can not be empty","first name");
        }        
        return null;
        
    }
}

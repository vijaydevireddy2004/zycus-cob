package com.zycus.cob.mock;

import com.zycus.cob.entities.Customer;
import com.zycus.cob.vo.Result;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CustomerUploadHandler {
    
    public List<Result> upload(String excelFile) throws FileNotFoundException, IOException{
        System.out.println("Uploading excel file ...");
        List<com.zycus.cob.vo.Result> errors = new ArrayList<>();
        if (excelFile.trim().equalsIgnoreCase("") || excelFile == null) {
            System.out.println("Uploading excel file ...is null");
            errors.add(new com.zycus.cob.vo.Result("1","Customer first name can not be empty","first name"));
            return errors;
        } else{
        FileInputStream inputStream = new FileInputStream(new File(excelFile));
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        int customerSheetCount = workbook.getNumberOfSheets();
        
        for(int i=0; i<customerSheetCount; i++){
            System.out.println("Uploading excel file ... reading sheets, current sheet:"+i);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowCount = sheet.getPhysicalNumberOfRows();
            for(int r=1; r<rowCount; r++){
                System.out.println("Uploading excel file ... reading row:"+r);
                XSSFRow currentRow = sheet.getRow(r);
                String id = currentRow.getCell(0).getStringCellValue();
                String firstName = currentRow.getCell(0).getStringCellValue();
                String middleName = currentRow.getCell(0).getStringCellValue();
                String lastName = currentRow.getCell(0).getStringCellValue();
                String dob = currentRow.getCell(0).getStringCellValue();                
                String description = currentRow.getCell(0).getStringCellValue();
                
                if(id==null || id.trim().equalsIgnoreCase("")){
                    System.out.println("Uploading excel file ...checking if id is null");
                    com.zycus.cob.vo.Result e;
                    e = new com.zycus.cob.vo.Result("1", "id can not be blank", "customerId");
                    errors.add(e);
                }else{
                    System.out.println("Uploading excel file ...creating new customer");
                    Customer c = new Customer(id, firstName, middleName, lastName, null, description);
                    CustomerOperations co = new CustomerOperations();
                    com.zycus.cob.vo.Result e = co.createCustomer(c);
                    System.out.println(e);
                    System.out.println(e.getError());                    
                    System.out.println("Uploading excel file ...done");
                }
            }
        }
        
        }       
        return errors;
    }
}

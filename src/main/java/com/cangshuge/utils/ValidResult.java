package com.cangshuge.utils;

import com.cangshuge.entity.JsonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ValidResult {
    public static JsonResult checkResult(BindingResult result){
        StringBuffer msg=new StringBuffer();
        List<FieldError> fieldErrors=result.getFieldErrors();
        for (FieldError fieldError:fieldErrors){
            msg.append(fieldError.getDefaultMessage()).append(",");
        }
        System.out.println(msg);
        return new JsonResult(msg.substring(0,msg.length()-1),false);
    }
}

package com.jonathan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//Response code: 1 represents success; 0 represents failure
    private String msg;  //Response information: description string
    private Object data; //Returned data

    //Add, delete or update successful response
    public static Result success(){
        return new Result(1,"success",null);
    }
    //select successful response
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //fail response
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}

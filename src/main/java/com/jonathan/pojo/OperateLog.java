package com.jonathan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    private Integer id; //ID
    private Integer operateUser; //operator ID
    private LocalDateTime operateTime; //Operation time
    private String className; //operation class name
    private String methodName; //Operation method name
    private String methodParams; //Operation method parameters
    private String returnValue; //Operation method return value
    private Long costTime; //The operation takes time
}

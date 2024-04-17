package com.jonathan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Employee entity class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender; //Gender, 1 male, 2 female
    private String image; //image url
    private Short job; //Position, 1 teacher, 2 lecturer, 3 academic supervisor, 4 teaching and research supervisor, 5 consultant
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

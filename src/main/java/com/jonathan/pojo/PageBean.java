package com.jonathan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Pagination query result encapsulation class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {

    private Long total;//total records
    private List rows;//data list

}

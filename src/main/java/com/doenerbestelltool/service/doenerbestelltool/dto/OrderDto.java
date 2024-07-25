package com.doenerbestelltool.service.doenerbestelltool.dto;

import java.util.List;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto {
    private String cusForename;
    private String cusSurename;
    private String product;
    private String price;
    private int size;
    private String sauce1;
    private String sauce2;
    private String meat;
    private List<String> specialWishes;
    private String specialInstruction;
    private LocalDateTime orderDate;
}
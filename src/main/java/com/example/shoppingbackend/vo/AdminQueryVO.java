package com.example.shoppingbackend.vo;

import lombok.Data;

import java.util.List;

@Data
public class AdminQueryVO {
    private Integer roleId;
    private List<Integer> adminIdList;
}

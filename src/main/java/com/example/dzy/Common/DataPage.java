package com.example.dzy.Common;

import lombok.Data;

import java.util.HashMap;

@Data
public class DataPage {
    private static int PAGE_SIZE = 10;
    private static int PAGE_NUM = 1;

    private Integer pageSize;
    private Integer pageNum;
    private HashMap param;
}

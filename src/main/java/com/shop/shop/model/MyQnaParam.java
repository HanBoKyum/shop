package com.shop.shop.model;

import lombok.Data;

@Data
public class MyQnaParam {
    String findStr = "";
    String qId = "";
    int totListSize = 0;
    int nowPage = 1;
    int qSerial = 0;
    int startNo = 1;
    int endNo = 1;
    int totPage = 1;


}

package com.shop.shop.model;

import lombok.Data;

@Data
public class Param {
    String findStr;
    String oneDate;
    String twoDate;
    int rSerial=1000;
    int category=1;
    String rId;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    int nowPage = 1;
    int totPage = 0;
    int startNo = 0;
    int endNo = 0;
}

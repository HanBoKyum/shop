package com.shop.shop.model;

import lombok.Data;

@Data
public class NoticeVo {
    int nSerial=0;
    String nSubject;
    String nContent;
    String nDate;
    int nHit=0;
    String nId;

    //List<FileVo> nList;
    //List<String> delFile;
}

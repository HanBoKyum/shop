package com.shop.shop.model;

import lombok.Data;

@Data
public class QuestionVo {
    int		qSerial;
    String	qId;
    String	qSubject;
    String	qContent;
    String	qDate;
    int		qPserial;
    String	qOrder;
}

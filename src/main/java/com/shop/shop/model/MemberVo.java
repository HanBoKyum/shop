package com.shop.shop.model;

import lombok.Data;

@Data
public class MemberVo {
    String mId;
    int mPwd;
    String mName;
    String mDate;
    String mJoin;
    String mGender;
    String mEmail;
    String mPhone;
}

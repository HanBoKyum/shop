package com.shop.shop.mapper;

import com.shop.shop.model.MyQnaParam;
import com.shop.shop.model.NoticeVo;
import com.shop.shop.model.Param;
import com.shop.shop.model.QuestionVo;

import java.util.List;

public interface NoticeMapper {
    List<NoticeVo> search(Param param) throws Exception;
    List<QuestionVo> searchh() throws  Exception;
    //QuestionVo viewQuestion(Param param) throws Exception;
    String question_insert(QuestionVo vo) throws  Exception;
    //List<QuestionVo> searchQuestion(Param param) throws Exception;
    //NoticeVo viewNotice(Param param) throws Exception;
    String notice_insert(NoticeVo vo) throws Exception;
    //List<NoticeVo> searchNotice(Param param) throws Exception;
    //List<QuestionVo> jaewookjjang(MyQnaParam param) throws Exception;
    int stay() throws Exception;
    int refund() throws Exception;
    int ask() throws Exception;
}

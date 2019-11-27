package com.shop.shop.mapper;

import com.shop.shop.model.MemberVo;

import java.util.List;

public interface ShopMapper {
    List<MemberVo> getAll() throws Exception;
    List<MemberVo> insertMember(MemberVo vo) throws Exception;
    MemberVo login(MemberVo vo) throws Exception;
}

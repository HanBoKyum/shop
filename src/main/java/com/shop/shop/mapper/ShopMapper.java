package com.shop.shop.mapper;

import com.shop.shop.model.MemberVo;

import java.util.List;

public interface ShopMapper {
    public List<MemberVo> getAll() throws Exception;

}

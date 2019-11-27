package com.shop.shop.service;

import com.shop.shop.mapper.ShopMapper;
import com.shop.shop.model.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    @Autowired
    ShopMapper shopMapper;

    public List<MemberVo> getAll() throws Exception{
        return shopMapper.getAll();
    }
    public List<MemberVo> insertMember(MemberVo vo) throws Exception{
        return shopMapper.insertMember(vo);
    }
    public MemberVo login(MemberVo vo) throws Exception{
        return shopMapper.login(vo);
    }
}

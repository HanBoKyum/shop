package com.shop.shop.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MyBatisFactory {



    private  static SqlSessionFactory factory;

    static{
        try{
            Reader reader = Resources.getResourceAsReader("../resources/mapper/config.xml");
            factory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static SqlSessionFactory getFactory(){
        return factory;
    }
}

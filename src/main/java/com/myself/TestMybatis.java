package com.myself;

import com.myself.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatisTest
 * @author: 吴小龙
 * @create: 2019-10-12 13:34
 * @description: mybatis的测试类
 */

public class TestMybatis {
    public static void main(String[] args) throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();


        List<Category> cs=session.selectList("listCategoryByName","category1");
        for(Category category:cs)
        {
            System.out.println(category.getName());
        }
//
////        session就是一级缓存，查过的语句不需要再去查询，就可以直接使用，快
//        List<Category> cs2=session.selectList("listCategoryByName","category1");
//        for(Category category:cs2)
//        {
//            System.out.println(category.getName());
//        }
        session.commit();
        session.close();


//        Category c=new Category();
//        c.setName("新增加的Category2");
//        session.insert("addCategory",c);
//        listAll(session);
//        session.commit();
//        session.close();




//        List<Category> cs=session.selectList("listCategory");
//        for (Category category:cs)
//        {
//            System.out.println(category.getName());
//        }
    }

    private static void listAll(SqlSession session){
        List<Category> cs=session.selectList("listCategory");
        for(Category c:cs)
        {
            System.out.println(c.getName());
        }
    }



}

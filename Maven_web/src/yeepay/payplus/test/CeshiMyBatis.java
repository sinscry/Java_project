package yeepay.payplus.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;
import yeepay.payplus.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 维C果糖 on 2017/2/1.
 */
public class CeshiMyBatis {
    public SqlSession sqlSession;
    public CeshiMyBatis() throws IOException {
        String resource = "sqlMapConfig.xml";           // 定位核心配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);    // 创建 SqlSessionFactory
        this.sqlSession = sqlSessionFactory.openSession();    // 获取到 SqlSession
    }


    @Test
    public void ceshi() throws IOException {
        /**
         *  1、获得 SqlSessionFactory
         *  2、获得 SqlSession
         *  3、调用在 mapper 文件中配置的 SQL 语句
         */
        // 调用 mapper 中的方法：命名空间 + id
        List<Person> personList = this.sqlSession.selectList("yeepay.payplus/mapper.UserMapper.findAll");

        for (Person p : personList){
            System.out.println(p);
        }
    }
}
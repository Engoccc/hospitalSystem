package web.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import web.example.users.User;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {
    /***
    public static void main(String[] args) throws IOException {
        //mybatis的配置文件
        String resource = "mapping/conf.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL

        String statement = "userMapper.addUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        User user = new User("15760047745","piong","male","513922199711241234","123456789","123456");
        int retResult = session.insert(statement,user);        //手动提交事务
        session.commit();
        //使用SqlSession执行完SQL之后需要关闭SqlSession
        session.close();
        System.out.println(retResult);

    }
     */
}
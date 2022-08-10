import com.mybatis.mapper.CacheMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class CacheMapperTest {

    /**
     * MyBatis的一级缓存
     * MyBatis的一级缓存是SqlSession级别的，通过同一个SqlSession查询的数据会被缓存
     * 再次使用同一个SqlSession查询同一个数据，就会从缓存中直接获取，不会从数据库重新访问
     * 使一级缓存失效的四种情况：
     * 1) 不同的SqlSession对应不同的一级缓存
     * 2) 同一个SqlSession但是查询条件不同
     * 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4) 同一个SqlSession两次查询期间手动清空了缓存
     *
     * MyBatis的二级缓存
     * MyBatis的二级缓存是SqlSessionFactory级别，通过同一个SqlSessionFactory
     * 创建的SqlSession查询的结果会被缓存；此后若再次执行相同的查询语句，结果就会从缓存中获取
     * MyBatis的二级缓存开启的条件：
     * a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     * b>在映射文件中设置标签<cache/>
     * c>二级缓存必须在SqlSession关闭或提交之后有效
     * d>查询的数据所转换的实体类类型必须实现序列化的接口
     * 使二级缓存失效的情况：
     * 两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
     */
    @Test
    public void testGetEmpById(){
        SqlSession session = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = session.getMapper(CacheMapper.class);
        Emp emp = mapper.getEmpById(1);
        System.out.println(emp);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);
        SqlSession session2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = session.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpById(1);
        System.out.println(emp);
    }


}

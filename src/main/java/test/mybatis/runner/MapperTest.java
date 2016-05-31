package test.mybatis.runner;

import org.junit.Test;
import test.mybatis.entity.Mobile;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;
import test.mybatis.mapper.MobileMapper;

public class MapperTest extends MyBatisJUnitTest {

    @Test
    @MyBatis
    public void test() {
        MobileMapper mobileMapper = sqlSession.getMapper(MobileMapper.class);
        int res = mobileMapper.insertMobile(new Mobile("ios", "apple", "iphone 6", 4588));
        assertEquals(1, res);
    }

}

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
        int res = mobileMapper.insertMobile(getMobile());
        assertEquals(1, res);
    }

    private Mobile getMobile() {
        Mobile mobile = new Mobile();
        mobile.setOs("ios");
        mobile.setBrand("apple");
        mobile.setModel("iphone 6");
        mobile.setPrice(4588);
        return mobile;
    }

}

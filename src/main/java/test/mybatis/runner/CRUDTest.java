package test.mybatis.runner;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;
import test.mybatis.entity.Mobile;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;

import java.util.List;
import java.util.Map;

public class CRUDTest extends MyBatisJUnitTest {

    @Test
    @MyBatis
    public void testSelectOne() {
        Mobile mobile = sqlSession.selectOne("test.mybatis.mapper.MobileMapper.selectMobileById", 1);
        assertNotNull(mobile);
    }

    @Test
    @MyBatis
    public void testSelectList() {
        List<Mobile> mobiles = sqlSession.selectList("test.mybatis.mapper.MobileMapper.selectAllMobile");
        assertTrue(CollectionUtils.isNotEmpty(mobiles));
    }

    @Test
    @MyBatis
    public void testSelectMap() {
        Map<String, Object> mobileMap = sqlSession.selectMap("test.mybatis.mapper.MobileMapper.selectAllMobileForMap", "id");
        assertTrue(MapUtils.isNotEmpty(mobileMap));
    }

}

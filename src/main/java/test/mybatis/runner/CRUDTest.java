package test.mybatis.runner;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.ibatis.cursor.Cursor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.mybatis.entity.Mobile;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;
import test.mybatis.result.EntityResultHandler;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CRUDTest extends MyBatisJUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(CRUDTest.class);

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

    @Test
    @MyBatis
    public void testSelectCursor() {
        Cursor<Mobile> cursor = sqlSession.selectCursor("test.mybatis.mapper.MobileMapper.selectAllMobile");
        assertNotNull(cursor);
        for (Iterator<Mobile> iterator = cursor.iterator(); iterator.hasNext(); ) {
            logger.debug(iterator.next().toString());
        }
    }

    @Test
    @MyBatis
    public void testSelect() {
        EntityResultHandler<Mobile> resultHandler = new EntityResultHandler<Mobile>();
        sqlSession.select("test.mybatis.mapper.MobileMapper.selectAllMobile", resultHandler);
        List<Mobile> mobiles = resultHandler.getResults();
        assertTrue(CollectionUtils.isNotEmpty(mobiles));
        for (Mobile mobile : mobiles) {
            logger.debug(mobile.toString());
        }
    }

    @Test
    @MyBatis
    public void testInsert() {
        int res = sqlSession.insert("test.mybatis.mapper.MobileMapper.insertMobile", new Mobile("android", "google", "nexus 6", 2390));
        assertEquals(1, res);
    }

    @Test
    @MyBatis
    public void testDelete() {
        int res = sqlSession.delete("test.mybatis.mapper.MobileMapper.deleteMobile", 1);
        assertEquals(1, res);
    }

    @Test
    @MyBatis
    public void testUpdate() {
        int res = sqlSession.update("test.mybatis.mapper.MobileMapper.updateMobilePrice", new Mobile(2, 2250));
        assertEquals(1, res);
    }

    @Test
    @MyBatis(autoCommit = false)
    public void testCommitAndRollback() {
        try {
            sqlSession.insert("test.mybatis.mapper.MobileMapper.insertMobile", new Mobile("android", "samsung", "galaxy a9", 2999));
            otherDBOperations();
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        }
    }

    private void otherDBOperations() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException();
        }
    }

}

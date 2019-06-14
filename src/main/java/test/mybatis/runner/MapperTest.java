package test.mybatis.runner;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import test.mybatis.entity.Mobile;
import test.mybatis.entity.SingleTable;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;
import test.mybatis.mapper.MobileMapper;
import test.mybatis.mapper.SingleTableMapper;

public class MapperTest extends MyBatisJUnitTest {

    @Test
    @MyBatis
    public void test() {
        MobileMapper mobileMapper = sqlSession.getMapper(MobileMapper.class);
        int res = mobileMapper.insertMobile(new Mobile("ios", "apple", "iphone 6", 4588));
        assertEquals(1, res);
    }

    @Test
    @MyBatis
    public void testSingleTable() {
        SingleTableMapper singleTableMapper = sqlSession.getMapper(SingleTableMapper.class);
        for (int i = 0; i < 10000; i++) {
            int res = singleTableMapper.insertSingleTable(createSingleTable());
            assertEquals(1, res);
        }
    }

    private static SingleTable createSingleTable() {
        SingleTable singleTable = new SingleTable();
        singleTable.setKey1(randomString(3));
        singleTable.setKey2(RandomUtils.nextInt());
        singleTable.setKey3(randomString(3));
        singleTable.setKeyPart1(randomString(3));
        singleTable.setKeyPart2(randomString(3));
        singleTable.setKeyPart3(randomString(3));
        singleTable.setCommonField(randomString(3));
        return singleTable;
    }

    private static String randomString(int length) {
        return RandomStringUtils.random(length, "abcde");
    }

}

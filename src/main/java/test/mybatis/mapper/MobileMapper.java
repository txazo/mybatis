package test.mybatis.mapper;

import test.mybatis.entity.Mobile;

import java.util.List;
import java.util.Map;

public interface MobileMapper {

    public int insertMobile(Mobile mobile);

    public int deleteMobile(int id);

    public int updateMobilePrice(Mobile mobile);

    public Mobile selectMobileById(int id);

    public List<Mobile> selectAllMobile();

    public Map<String, Object> selectAllMobileForMap();

}

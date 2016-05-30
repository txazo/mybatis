package test.mybatis.handler;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@MappedTypes({Map.class})
@MappedJdbcTypes({JdbcType.VARCHAR})
public class JsonMapTypeHandler implements TypeHandler<Map<String, Object>> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Map<String, Object> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, JSON.toJSONString(parameter));
    }

    @Override
    public Map<String, Object> getResult(ResultSet rs, String columnName) throws SQLException {
        return JSON.parseObject(rs.getString(columnName), Map.class);
    }

    @Override
    public Map<String, Object> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return JSON.parseObject(rs.getString(columnIndex), Map.class);
    }

    @Override
    public Map<String, Object> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return JSON.parseObject(cs.getString(columnIndex), Map.class);
    }

}

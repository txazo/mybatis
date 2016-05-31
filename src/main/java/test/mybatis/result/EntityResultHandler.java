package test.mybatis.result;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

public class EntityResultHandler<T> implements ResultHandler<T> {

    private List<T> results = new ArrayList<T>();

    @Override
    public void handleResult(ResultContext<? extends T> resultContext) {
        results.add(resultContext.getResultObject());
    }

    public List<T> getResults() {
        return results;
    }

}

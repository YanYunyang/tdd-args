package cn.yanyunyang.args;

import java.util.List;

public class LoggingArgHandler implements ArgumentHandler {

    @Override
    public void parse(List<String> value,Result result) throws Exception {
        if (value.size() < 1) {
            result.setLogging(true);
            return;
        }
        if (value.size() > 1) {
            throw new TooManyArgumentException();
        }
        if ("true".equals(value.get(0))) {
            result.setLogging(true);
        }
        if ("false".equals(value.get(0))) {
            result.setLogging(false);
        }
        throw new BadArgumentException();
    }
}

package cn.yanyunyang.args;

import java.util.List;

public class PortArgHandler implements ArgumentHandler {
    @Override
    public void parse(List<String> value,Result result) throws Exception {
        if (value.size() < 1) {
            result.setPort(0);
            return;
        }
        if (value.size() > 1) {
            throw new TooManyArgumentException();
        }
        try {
            result.setPort(Integer.parseInt(value.get(0)));
        } catch (NumberFormatException e) {
            throw new BadArgumentException();
        }
    }
}

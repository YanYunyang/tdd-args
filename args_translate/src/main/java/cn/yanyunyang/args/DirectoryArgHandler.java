package cn.yanyunyang.args;

import java.util.List;

public class DirectoryArgHandler implements ArgumentHandler {

    @Override
    public void parse(List<String> value,Result result) throws Exception {
        if (value.size() < 1) {
            throw new MissingArgumentException();
        }
        if (value.size() > 1) {
            throw new TooManyArgumentException();
        }
        result.setDirectory(value.get(0));
    }
}

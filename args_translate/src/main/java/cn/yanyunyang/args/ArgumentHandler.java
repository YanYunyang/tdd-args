package cn.yanyunyang.args;

import java.util.List;

public interface ArgumentHandler {
    void parse(List<String> value,Result result) throws Exception;
}

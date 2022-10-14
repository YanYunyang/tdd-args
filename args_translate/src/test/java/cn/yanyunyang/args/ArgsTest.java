package cn.yanyunyang.args;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ArgsTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    //-l -p 8080 -d /usr/local
    //[-l],[-p,8080],[-d,/usr/local]
    @Test
    public void client_use_tool(){

    }
    @Test
    public void init_test() throws Exception {
        Result result = Args.parse("-l", "-p", "8080", "-d", "/usr/local");
        assert result.getLogging() == true;
        assert result.getPort() == 8080;
        assert result.getDirectory().equals("/usr/local");
    }

    @Test
    public void port_two_arg_should_throw_TooManyArgumentException() throws Exception {
        thrown.expect(TooManyArgumentException.class);
        Result result = Args.parse("-p","5","666");
    }

    @Test
    public void port_none_arguments_should_set_default_value() throws Exception {
        Result result = Args.parse("-p");
        assert result.getPort() == 0;
    }

}
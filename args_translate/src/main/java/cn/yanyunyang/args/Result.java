package cn.yanyunyang.args;

public class Result {
    private boolean logging;
    private int port;
    private String directory;
    boolean getLogging(){
        return this.logging;
    }

    int getPort(){
        return this.port;
    }

    String getDirectory(){
        return this.directory;
    }

    public void setLogging(boolean logging) {
        this.logging = logging;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }
}

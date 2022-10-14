package cn.yanyunyang.args;


import java.util.*;
import java.util.stream.Collectors;

public class Args {
    private static List<String> tag = new ArrayList(){
        {
            add("l");
            add("p");
            add("d");
        }
    };

    private static Map<String,Class> tagHandler = new HashMap(){
        {
            put("l",LoggingArgHandler.class);
            put("p",PortArgHandler.class);
            put("d",DirectoryArgHandler.class);
        }
    };

    public static Result parse(String ...args) throws Exception {
        List<String> arguments = Arrays.stream(args).collect(Collectors.toList());

        Map<String, List<String>> argsMap = getArgumentsMap(arguments);

        Result result = new Result();

        for (Map.Entry entry:argsMap.entrySet()){
            String key = (String) entry.getKey();
            List<String> value = (List<String>) entry.getValue();

            Class<ArgumentHandler> handlerClass = tagHandler.get(key);
            ArgumentHandler handler = handlerClass.newInstance();

            handler.parse(value,result);
        }
        return result;
    }

    private static Map<String, List<String>> getArgumentsMap(List<String> arguments) {
        Map<String,List<String>> argsMap = new HashMap<>();

        String currentTag = null;
        for (String v: arguments){
            if (v.contains("-")&&tag.contains(v.replace("-",""))){
                argsMap.put(v.replace("-",""),new ArrayList<>());
                currentTag = v.replace("-","");
                continue;
            }
            if (currentTag!=null){
                argsMap.get(currentTag).add(v);
            }
        }
        return argsMap;
    }
}

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Time {
    @Test
    public void getTime() throws IOException {
        String str="";
        List<String> strings = FileUtils.readLines
                (new File("e://17689415933.txt"), "utf-8");
        for(String line:strings){
            str+=line;
    }
        String[] split = str.split("message");
        for(String line:split){
            System.out.println("行头"+line+"行尾");
            String strPattern="domain.*transid=[a-zA-Z]*\\d+";
            Pattern compile = Pattern.compile(strPattern);
            Matcher matcher = compile.matcher(line);
            while (matcher.find()){
                System.out.println("匹配:"+matcher.group()+"结束");
                String group=matcher.group();
                String value=group.substring(group.indexOf("[")+1, group.lastIndexOf("]"));
                String key=group.substring(group.lastIndexOf("=")+1);
                System.out.println("value:"+value+"---key:"+key);
            }
            String strPattern1="domain.*<transid>\\d+</transid>";
            Pattern compile1 = Pattern.compile(strPattern1);
            Matcher matcher1 = compile1.matcher(line);
            while (matcher1.find()){
                System.out.println("匹配:"+matcher1.group()+"结束");
                String group=matcher1.group();
                String value=group.substring(group.indexOf("[")+1, group.lastIndexOf("]"));
                String key=group.substring(group.lastIndexOf("<transid>")+9,
                        group.lastIndexOf("</transid>"));
                System.out.println("value:"+value+"---key:"+key);

            }
        }
}
}

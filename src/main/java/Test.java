import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.google.gson.Gson;
import org.apache.flume.instrumentation.SourceCounter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.*;
import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.LoggerFactory;
import util.HttpUtils;

import javax.sound.midi.SoundbankResource;
import java.io.*;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.apache.log4j.spi.Configurator.NULL;

public class Test {
    public static void main(String[] args) {
////        String path="hdfs://192.168.209.1:9001/user/hive/warehouse/test/test.txt";
//        String path="hdfs://192.168.209.1:9001/user/hive";
//        Configuration conf = new Configuration();
//        conf.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
//        conf.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());
//
//        Path inputPath=new Path(path);
//
//        FileSystem hdfs=null;
//        try {
//            hdfs = FileSystem.get(URI.create(path), conf);
//            visitPath(hdfs,path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//    public static void visitPath(FileSystem fs,String path) throws IOException
//    {
//        Path inputDir = new Path(path);
//        FileStatus[] inputFiles = fs.listStatus(inputDir);
//        if(inputFiles==null)
//        {
//            throw new IOException(" the path is not correct:" + path);
//        }
//
//        System.out.println("----------------path:"+path+"----------------");
//        for (int i = 0; i < inputFiles.length; i++) {
//
//
//
//            if(inputFiles[i].isDir())
//            {
//                System.out.println(inputFiles[i].getPath()+" -dir-");
//                visitPath(fs,inputFiles[i].getPath().toString());
//            }
//            else
//            {
//                System.out.println(inputFiles[i].getPath().getName()+",len:"+inputFiles[i].getLen());
//            }
//
//        }
//
//        System.out.println("asdfasdfd*32".contains("*"));
//        System.out.println("asdfasd/fd*32".lastIndexOf("/"));
//        int a="asdfasd/fd*32".lastIndexOf("/");
//        System.out.println("asdfasd/fd*32".substring(0,a));
//        int b="asdfasd/fd*32".lastIndexOf("*");
//        System.out.println("asdfasd/fd*32".substring(a,b));
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
//        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

//        String str="{\"liu\":\"123\",\"yang\":\"456\",\"song\":\"456\"}";
//        JSONObject js=JSONObject.parseObject(str);
//        System.out.println(js);
//        if(js.containsKey("liu")){
//            js.remove("liu");
//        }
//        String str2=js.toJSONString();
//        System.out.println(js);
//        System.out.println(str2);

//            String path="d://test.txt";
//            try{
//                FileInputStream fis=new FileInputStream(new File(path));
//                BufferedReader br=new BufferedReader(new InputStreamReader(fis));
//                String line=null;
//                while((line=br.readLine())!=null){
//                    System.out.println(line);
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        System.out.println(""==NULL);
//        System.out.println(NULL==NULL);
//        System.out.println("".equals(null));
//        Map map=new HashMap();
//        map.put("132",null);
//        System.out.println(map.get("132"));
//        String json="{\"liu\":\"123\",\"yang\":\"456\",\"song\":\"456\"}";
//        JSONObject js=JSONObject.parseObject(json);
//        System.out.println(js);

//        List<String> list=new LinkedList<String>();
////        System.out.println(list.size());
//////        list.add("liu");
//////        list.add("yang");
//////        list.add("song");
//////        for(String str:list){
//////            System.out.println(str);
//////        }
////        System.out.println("lll"=="lll");
//        String str="*12*";
//        str=str.substring(str.indexOf("*")+1,str.lastIndexOf("*"));
//        System.out.println(PROJECT_PATH);
//        System.out.println(PROJECT_PATH.substring(0,PROJECT_PATH.lastIndexOf("\\")));
//        int i=0;
//        while(true){
//            try {
//                logger1.info("1231321");
//                logger2.info(String.valueOf(++i));
//                Thread.sleep(1000*30);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        FileWriter fw=null;
//        FileReader fr=null;
//        BufferedReader br=null;
//        try {
//            Map map=new HashMap();
//            map.put("\"hdfs://host01:9001/user/hive/warehouse/dim_skill_queue_prov/dim_skill_queue_prov-data.txt\"","21");
//            System.out.println(map);
//            fw=new FileWriter("d://abc.txt",false);
//            fr=new FileReader("d://abc.txt");
//            br=new BufferedReader(fr);
//            fw.write(String.valueOf(map));
//            fw.flush();
//            fw.close();
//            String s = br.readLine();
//            System.out.println(s.length());
//            Gson gson = new Gson();
//            Map<String,String> mapa = new HashMap<String,String>();
//            mapa = gson.fromJson(s, mapa.getClass());
//            System.out.println("这是map"+mapa);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            String s = HttpUtils.doGet("http://132.46.139.11/msQuery/msgquery/getMessageDetail.htm?mobile=17693635125&startDay=2019-01-19&endDay=2019-01-28");
//            System.out.println(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        SourceCounter sourceCounter=new SourceCounter("source1");
//        sourceCounter.addToEventAcceptedCount(1);
//        sourceCounter.addToEventReceivedCount(6);
//        sourceCounter.incrementAppendAcceptedCount();
//        sourceCounter.incrementAppendAcceptedCount();
//        sourceCounter.incrementAppendBatchAcceptedCount();
//        sourceCounter.incrementEventAcceptedCount();
//        sourceCounter.incrementEventReceivedCount();
//        System.out.println(sourceCounter.getAppendAcceptedCount());
//        System.out.println(sourceCounter.getEventReceivedCount());
        RandomAccessFile rAccessFile= null;
        File file=new File("e://return.txt");
        byte[] readBuffer=new byte[1024];
        int read=1024;
        try {
            rAccessFile = new RandomAccessFile(file,"r");
            MappedByteBuffer map = rAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, 0,file.length());
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            for(int offset=0;offset<file.length();offset+=read){
                if(offset+read>file.length()){
                    read= (int) (file.length()-offset);
                }
                map.get(readBuffer, 0, read);
                for(int i=0;i<read;i++){
                    byte tmp=readBuffer[i];
                    if(tmp=='\n'||tmp=='\r'){
                        System.out.println("一行"+baos.toString("utf-8"));
                        baos.reset();
                    }else {
                        baos.write(tmp);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
//    static {
//        if ( System.getProperty("log4j.configuration") != null ){
//            PropertyConfigurator.configure(System.getProperty("log4j.configuration"));
//        }else{
//            BasicConfigurator.configure();
//        }
//        BasicConfigurator.configure();
//        String path = new File("").getAbsolutePath();
//        System.out.println(path);
//        Date date=new Date();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm");
//        String format = simpleDateFormat.format(date);
//        FileAppender appender = (FileAppender) org.apache.log4j.Logger.getRootLogger().getAppender("File");
//        appender.setFile(path + File.separator+"log-"+format+".log");
//////        appender.setAppend(true);
////        appender.setEncoding("utf-8");
////        appender.setImmediateFlush(false);
////        appender.setThreshold(Priority.DEBUG);
//
//        appender.activateOptions();
//    }
//    private static Logger logger1 = Logger.getLogger("a");
//    private static Logger logger2= Logger.getLogger("b");


//    private static final String PROJECT_PATH = System.getProperty("user.dir");

}

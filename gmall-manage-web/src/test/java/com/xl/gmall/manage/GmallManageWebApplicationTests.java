package com.xl.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
     //配制fdfs的全局连接地址
     String file=GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();//获得配制文件的路径
        ClientGlobal.init(file);
        TrackerClient trackerClient = new TrackerClient();
        //获得一个trackerServer的实例
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        //通过tarcker或的一个  Storage的连接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String[] uploadinfo = storageClient.upload_file("d:/b.jpg","jpg",null);
        String url="http:192.168.174.129";
        for (String s : uploadinfo) {
            url += "/"+s ;
        }
        System.out.println(url);

    }

}

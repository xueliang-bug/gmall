package com.xl.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: Administrator
 * @Date: 2020/6/9 15:58
 * @Description: com.xl.gmall.manage.util
 * @version: 1.0
 */
public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile) {
        String imageurl="http:192.168.174.129";
        //上传图片到服务器
        //配制fdfs的全局连接地址
        String file=PmsUploadUtil.class.getResource("/tracker.conf").getPath();//获得配制文件的路径
        try {
            ClientGlobal.init(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        //获得一个trackerServer的实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过tarcker或的一个  Storage的连接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);
        try {
            byte[] bytes = multipartFile.getBytes();//获取二进制的对象
            //截取文件后缀
            String originalFilename = multipartFile.getOriginalFilename();//b.jpg
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i+1);
            String[]  uploadinfo = storageClient.upload_file(bytes,extName,null);
            for (String s : uploadinfo) {
                imageurl += "/"+s ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return imageurl;
    }
}

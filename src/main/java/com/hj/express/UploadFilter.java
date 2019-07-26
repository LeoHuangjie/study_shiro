package com.hj.express;

import cn.hutool.http.ContentType;
import org.springframework.http.HttpEntity;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author huangjie
 * @time 2019-07-26 14:53
 */
public class UploadFilter {

//    public static String uploadFile(InputStream inputStream) throws IOException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        String dateStr = sdf.format(new Date());
//        String fileNameSource = String.format("%d.mp3", System.currentTimeMillis());
//        String fileExtName = fileNameSource.substring((fileNameSource.lastIndexOf('.') - 1) + 1).toLowerCase();
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        String fileName = uuid + fileExtName;
//        String prePath = "/upload/pigai/" + dateStr + "/";
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        HttpPost post = new HttpPost(SystemGlobals.getPreference("framework.upload.url"));
//        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(10000).setConnectionRequestTimeout(1000).setSocketTimeout(5000).build();
//        post.setConfig(requestConfig);
//        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
//        builder.addBinaryBody("file", inputStream, ContentType.MULTIPART_FORM_DATA, fileName);
//        builder.addTextBody("project", SystemGlobals.getPreference("framework.upload.project"));
//        builder.addTextBody("appkey", SystemGlobals.getPreference("framework.upload.appKey"));
//        builder.addTextBody("cusdir", prePath);
//        HttpEntity entity = builder.build();
//        post.setEntity(entity);
//        CloseableHttpResponse closeableHttpResponse = httpClient.execute(post);
//        HttpEntity responseEntity = closeableHttpResponse.getEntity();
//        String resultStr = EntityUtils.toString(responseEntity, Charset.forName("UTF-8"));
//        //log.error("resultStr=" + resultStr);
//        UrlBody urlBody = JSONObject.parseObject(resultStr, UrlBody.class);
//        if (urlBody.getCode() == 200) {
//            return urlBody.getResponse();
//        } else {
//            throw new RuntimeException("上传失败，code=" + urlBody.getCode() + ",message=" + urlBody.getResponse());
//        }
//    }
}

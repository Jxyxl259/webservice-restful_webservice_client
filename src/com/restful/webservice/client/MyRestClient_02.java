package com.restful.webservice.client;

import com.google.gson.Gson;
import com.restful.webservice.entity.Student;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class MyRestClient_02 {

    public static void main(String[] args) throws Exception{
        //创建一个HttpClient客户端
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        //创建一个HTTP POST请求
        HttpPost postRequest = new HttpPost("http://192.168.1.16:9999/rs_post_demo/getPupilInfo");

        Student stu = new Student();
        stu.setAge(24);
        stu.setName("jiangbug");
        stu.setAdult(true);
        stu.setGrade("11");

        Gson g= new Gson();
        String pupil = g.toJson(stu);

        //创建一个字符串HttpEntity对象
        HttpEntity entity = new StringEntity(pupil,"UTF-8");

        //将封装有具体参数内容的表单对象设置到HTTP POST请求中
        postRequest.setEntity(entity);

        //让创建的Http Client 执行我们创建的HTTP POST请求  并返回一个相应结果
        CloseableHttpResponse response = httpClient.execute(postRequest);

        //在相应结果中获取实体
        HttpEntity resEntity = response.getEntity();
        //获得到的这个HttpEntity实际上是一个流对象,可以使用InputStream接受,在将这个流转化为字符串
        //InputStream content = resEntity.getContent();
        //不过WebService提供了一个工具类:EntityUtils,可以直接将这个流转换为字符串

        //访问成功的状态码为200时打印获调用Restful风格的服务取到的信息
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            //设置输出的编码格式
            System.out.println(EntityUtils.toString(resEntity,"UTF-8"));

        }else{//访问失败,打印HTTP错误码
            System.out.println(response.getStatusLine());
        }
        postRequest.completed();
        //最后将这个获取到的这个流对象消费掉
        EntityUtils.consume(resEntity);
        //将创建的客户端关闭
        httpClient.close();

    }
}

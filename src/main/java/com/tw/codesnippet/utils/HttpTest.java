package com.tw.codesnippet.utils;

import cn.hutool.core.date.DateUtil;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class HttpTest {
    /**
     * 定义一个不安全方法：在高并发情况下得不到想要的结果
     * queryTimes 是一个不安全的属性；
     * getTimes是一个不安全方法；
     */
    static int queryTimes = 0;
    public static int getTimes(){
        queryTimes = queryTimes +1;
        return queryTimes;
    }

    /**
     * 200个线程来执行获取getTimes
     * @param args
     */
    public static void main(String[] args) {

        parallelTesk(10, new Runnable() {
            @Override
            public void run() {
                // System.out.println(getTimes());
                //
                // OkHttpClient okHttpClient  = new OkHttpClient.Builder()
                //     .connectTimeout(10, TimeUnit.SECONDS)
                //     .writeTimeout(10,TimeUnit.SECONDS)
                //     .readTimeout(20, TimeUnit.SECONDS)
                //     .build();
                //
                // String json = "{\"draft\":true,\"objectiveId\":721767,\"ownerId\":146339,\"comment\":\"a\"}";
                //
                // //MediaType  设置Content-Type 标头中包含的媒体类型值
                // RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"), json);
                //
                // Request request = new Request.Builder()
                //     .url("http://ddo-stable.intra.didichuxing.com/api/v2/objective/changeObjectiveProcess")//请求的url
                //     .post(requestBody)
                //     .header("Cookie", "_ga=GA1.2.1678868770.1684128402; _ga_4W379J3DW4=GS1.1.1684128401.1.1.1684128441.0.0.0; _kylin_username=xialixing; _kylin_username_zh=%E5%A4%8F%E7%AB%8B%E8%A1%8C; csrfToken=4tHqkpFGAA6ca5Vw42OD4o6Q; _OMGID=304d346f-5431-40d1-b143-c906f852c0ab; m_ldap=liuyong; m_name=%E4%BC%A6%E6%B3%BD; m_photo=https://s3-encrypt-inter.didistatic.com/m-data/mdm-card/workphotos/c3b76d8893be416786f29589cb86841f.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKDD00000000000EFQSFRFDRKQUMHY%252F20230518%252Fpyencrypt%252Fs3%252Faws4_request&X-Amz-Date=20230518T161514Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=eadd86e059201cede2d68eaa70ad74973bc51e3df82afacf7bb7b87a2b1c4f93; m_empId=D00198; curlanguage=zh-CN; _kylin_ticket=2dce59b8b1382d1ddc515d3c7946898d0001268000; lang=zh-CN; __hash__wa=20230529-ddo-liuyong-790694c0-e493-422b-bdf4-cc0f4fa7a809; __hash__cache=790694c0-e493-422b-bdf4-cc0f4fa7a809; user-fingerprint-water-mark=20230529-ddo-liuyong-790694c0-e493-422b-bdf4-cc0f4fa7a809; chooseDeptId=146339")
                //     .build();
                //
                // //创建/Call
                // Call call = okHttpClient.newCall(request);
                // //加入队列 异步操作
                // call.enqueue(new Callback() {
                //     @Override
                //     public void onFailure(Request request, IOException e) {
                //         System.out.println("连接失败");
                //     }
                //
                //     @Override
                //     public void onResponse(Response response) throws IOException {
                //         System.out.println(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss.SSS") + "---" + response.body().string());
                //     }
                // });
            }
        });
    }

    /**
     * 高并发测试：
     * 创建threadNum个线程；
     * 执行任务task
     * @param threadNum 线程数量
     * @param task 任务
     */
    public static void parallelTesk(int threadNum, Runnable task){

        // 1. 定义闭锁来拦截线程
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate  = new CountDownLatch(threadNum);

        // 2. 创建指定数量的线程
        for (int i = 0; i <threadNum; i++) {
            Thread t = new Thread(() -> {
                try {
                    startGate.await();
                    try {
                        task.run();
                    } finally {
                        endGate.countDown();
                    }
                } catch (InterruptedException e) {

                }
            });

            t.start();
        }

        // 3. 线程统一放行，并记录时间！
        long start =  System.nanoTime();

        startGate.countDown();
        try {
            endGate.await();
        } catch (InterruptedException e) {
        }

        long end = System.nanoTime();
        System.out.println("cost times :" +(end - start));
    }
}

package com.example.webpack;

import com.example.webpack.POJO.JUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;


/*
开源的Jackson：SpringBoot默认是使用Jackson作为JSON数据格式处理的类库，Jackson在各方面都比较优秀，所
以不建议将Jackson替换为Gson或fastjson。

Google的Gson：Gson是Google为满足内部需求开发的JSON数据处理类库，其核心结构非常简单，
toJson与fromJson两个转换函数实现对象与JSON数据的转换，

阿里巴巴的FastJson：Fastjson是阿里巴巴开源的JSON数据处理类库，其主要特点是序列化速度快。
当并发数据量越大的时候，越能体现出fastjson的优势。但是笔者觉得选择JSON处理类库，快并不是唯一需要考虑的因素，
与数据库或磁盘IO相比，JSON数据序列化与反序列化的这点时间还不足以对软件性能产生比较大的影响。
 */

//此处测试所用为jackson
public class JsonTest {
    @Test
    /**
     * 测试手动实体类转化为Json 字符串
     */
    public void testO2J() throws IOException {
        JUser user = new JUser(0L, "测试用户",new Date());
        System.out.println(user);

        //jackson的ObjectMapper 转换对象
        ObjectMapper mapper = new ObjectMapper();


        //对象转json字符串,使用writeValueAsString
        String ju = mapper.writeValueAsString(user);
        System.out.println(ju);

        //json字符串转对象,使用
        user = mapper.readValue(ju, JUser.class);
        System.out.println(user);


    }
}

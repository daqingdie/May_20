package com.example.webpack.POJO;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@JsonPropertyOrder(value = {"name","createtime"})
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
//@JsonPropertyOrder(value={"pname1","pname2"}) 改变子属性在JSON序列化中的默认定义的顺序。如：param1在先，param2在后。
public class JUser {
    @JsonIgnore
    private Long id;    //@JsonIgnore 排除某个属性不做序列化与反序列化

    @JsonProperty("username")
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    /*
    @JsonInclude(JsonInclude.Include.NON_NULL) 排除为空的元素不做序列化反序列化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") 指定日期类型的属性格式
     */
    private Date createTime;


}

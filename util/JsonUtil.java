package com.yunva.admin.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @Author: jianning.jiang
 * @Date: Created in 2017/11/15 9:18
 * @Description:json工具类
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public JsonUtil() {
    }

    static{
        //2、配置为true表示mapper允许接受只有一个元素的数组的反序列化
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
        //3、配置为false表示mapper在遇到mapper对象中存在json对象中没有的数据变量时不报错，可以进行反序列化
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        //4、定义针对日期类型的反序列化时的数据格式
        //objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }


    /**
     * 对象序列化为JSON字符串
     * @param object
     * @return
     */
    public static String getJsonFromObject(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * JSON字符串反序列化对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObjectFromJson(String json,Class<T> clazz){
        if(StringUtils.isEmpty(json)){
            return null;
        }
        try {
            return objectMapper.readValue(json,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T getObjectFromJson(byte[] val, TypeReference ref){
        if(StringUtils.isEmpty(val)){
            return null;
        }
        try {
            return (T) objectMapper.readValue(val,ref);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * JSON Array字符串反序列化对象
     * @param json
     * @param typeRef
     * @param <T>
     * @return
     */
    public static <T> T getObjectFromJson(String json, TypeReference<T> typeRef){
        if(StringUtils.isEmpty(json)){
            return null;
        }
        try {
            return objectMapper.readValue(json,typeRef);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.yan.util;

import com.yan.yml.Person;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.support.ManagedList;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

import static org.codehaus.jackson.map.DeserializationConfig.Feature.USE_JAVA_ARRAY_FOR_JSON_ARRAY;

public class BeanUtil {
    @SuppressWarnings("all")
    public static <T> T deepClone(T t) throws IOException {
        Class<T> clazz = (Class<T>) t.getClass();
        if (null == t) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes = objectMapper.writeValueAsBytes(t);
//        if (clazz.isArray()) {
//            objectMapper.configure(USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//        }
        return (T) objectMapper.readValue(bytes, t.getClass());
    }

    @SuppressWarnings("all")
    public static <T> List<T> deepCloneList(List<T> tList) throws IOException {
        if (tList == null) {
            return null;
        }
        if (tList.size() == 0 || tList.stream().allMatch(Objects::isNull)) {
            return new LinkedList<>();
        }
        Class clazz = null;
        for (T t : tList) {
            if (t != null) {
                clazz = t.getClass();
                break;
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(Collection.class, clazz);
        return objectMapper.readValue(objectMapper.writeValueAsString(tList), collectionType);
    }

    @SuppressWarnings("all")
    public static <K, V> Map<K, V> deepCloneMap(Map<K, V> map) throws IOException {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return new LinkedHashMap<>();
        }
        Class<K> kClass = null;
        Class<V> vClass = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key != null && value != null) {
                kClass = (Class<K>) key.getClass();
                vClass = (Class<V>) value.getClass();
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        MapType javaType = objectMapper.getTypeFactory().constructMapType(HashMap.class, kClass, vClass);
        return objectMapper.readValue(objectMapper.writeValueAsString(map), javaType);
    }

}

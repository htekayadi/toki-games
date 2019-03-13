package com.toki.games.utils;

import com.toki.games.model.Flight;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RequestUtil {
    public static Set<String> getFilteredFieldNames(String fields) {
        if(fields.isEmpty()){
            return Arrays.stream(Flight.class.getDeclaredFields()).map(f -> f.getName()).collect(Collectors.toSet());
        }else {
            return new HashSet<>(Arrays.asList(fields.split(",")));
        }
    }

    public static String getParameterValueByKey(MultiValueMap<String, String> params, String key, String defaultValue){
        String value = params.get(key) == null ? defaultValue : String.valueOf(params.get(key));
        return value.replace("[","").replace("]","");
    }
}

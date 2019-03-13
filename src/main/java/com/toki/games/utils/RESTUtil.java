package com.toki.games.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.Set;

public class RESTUtil {
    public static ObjectMapper getObjectMapper(Set<String> fieldArray) {
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("flight",
                SimpleBeanPropertyFilter.filterOutAllExcept(fieldArray));
        ObjectMapper om = new ObjectMapper();
        om.setFilterProvider(filterProvider);
        return om;
    }
}

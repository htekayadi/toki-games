package com.toki.games.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Set;

public class RESTUtil {
    public static ObjectMapper getObjectMapper(Set<String> fieldArray) {
        SimpleFilterProvider filterProvider = new SimpleFilterProvider();
        filterProvider.addFilter("flight",
                SimpleBeanPropertyFilter.filterOutAllExcept(fieldArray));
        ObjectMapper om = new ObjectMapper();

        //serialize LocalDateTime
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        om.setFilterProvider(filterProvider);
        return om;
    }
}

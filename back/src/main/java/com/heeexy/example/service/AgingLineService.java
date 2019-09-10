package com.heeexy.example.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.heeexy.example.dto.AgingLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hr-myq on 17-2-20.
 */
@Service
@CacheConfig(cacheNames = "AgingLine")
public class AgingLineService {
    private Logger logger = LoggerFactory.getLogger(AgingLineService.class);

    @Autowired
    private CacheManager cacheManager;

    @Value("${aginglines.json.file}")
    private String aginglinesJsonFile;

    @Cacheable(value = "AgingLine", key = "#root.methodName")
    public List<AgingLine> list() throws IOException {
        List<AgingLine> result = null;

        Cache.ValueWrapper valueWrapper = cacheManager.getCache("AgingLine").get("list");
        if (valueWrapper != null) {
            result = (List<AgingLine>) valueWrapper.get();
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, AgingLine.class);
            result = (List<AgingLine>) objectMapper.readValue(
                    ClassUtils.getDefaultClassLoader().getResource(aginglinesJsonFile),
                    javaType);
            cacheManager.getCache("AgingLine").put("list", result);
        }
        return result;
    }

    public AgingLine find(AgingLine agingLine) throws IOException {
        for (AgingLine item : list()) {
            if (item.equals(agingLine)) {
                return item;
            }
        }
        return null;
    }

    public void update(List<AgingLine> lst) {
        cacheManager.getCache("AgingLine").clear();
        cacheManager.getCache("AgingLine").put("list", lst);
    }

    @Cacheable(value = "AgingLine", key = "#agingLineIp")
    public AgingLine find(String agingLineIp) throws IOException {
        AgingLine agingLine = new AgingLine();
        agingLine.setLcServerIp(agingLineIp);
        return find(agingLine);
    }

    @Cacheable(value = "AgingLine", key = "#lineId")
    public AgingLine find(Integer lineId) throws IOException {
        AgingLine agingLine = new AgingLine(lineId);
        return find(agingLine);
    }
}

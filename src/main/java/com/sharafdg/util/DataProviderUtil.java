package com.sharafdg.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sharafdg.dao.Dao;

import java.io.InputStream;
import java.util.Iterator;

public class DataProviderUtil<T extends Dao> {

    private final Class<T> clazz;
    private final ObjectMapper mapper;

    public DataProviderUtil(Class<T> clazz) {
        this.clazz = clazz;
        this.mapper = new ObjectMapper();
    }

    public Object[][] readData(String testcaseName, String filename) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("test-data/" + filename);

        JsonNode rootNode = mapper.readTree(inputStream);
        JsonNode dataNode = rootNode.get(testcaseName);

        Object[][] testData = new Object[dataNode.size()][1];

        Iterator<JsonNode> it = dataNode.elements();
        int index = 0;
        T obj = null;
        while (it.hasNext()) {
            T data = mapper.treeToValue(it.next(), clazz);
            testData[index++][0] = data;
        }
        return testData;
    }
}

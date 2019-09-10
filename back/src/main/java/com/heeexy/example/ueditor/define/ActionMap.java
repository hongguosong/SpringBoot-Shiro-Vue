package com.heeexy.example.ueditor.define;

import java.util.HashMap;
import java.util.Map;

public final class ActionMap {

    private ActionMap() {

    }

    public static final int CONFIG = 0;
    public static final int UPLOAD_IMAGE = 1;
    public static final int UPLOAD_SCRAWL = 2;
    public static final int UPLOAD_VIDEO = 3;
    public static final int UPLOAD_FILE = 4;
    public static final int CATCH_IMAGE = 5;
    public static final int LIST_FILE = 6;
    public static final int LIST_IMAGE = 7;

    public static final Map<String, Integer> mapping = new HashMap() {
        {
            put("config", CONFIG);
            put("uploadimage", UPLOAD_IMAGE);
            put("uploadscrawl", UPLOAD_SCRAWL);
            put("uploadvideo", UPLOAD_VIDEO);
            put("uploadfile", UPLOAD_FILE);
            put("catchimage", CATCH_IMAGE);
            put("listfile", LIST_FILE);
            put("listimage", LIST_IMAGE);
        }
    };

    public static int getType(String key) {
        return ((Integer) mapping.get(key)).intValue();
    }
}
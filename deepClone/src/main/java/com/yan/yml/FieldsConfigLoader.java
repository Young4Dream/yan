package com.yan.yml;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FieldsConfigLoader {

    private static Map<String, ReportFieldConfig> fieldConfigMap = new HashMap<>();

    static {
        try {
            List<ReportFieldConfig> fieldConfigs = new YamlConfigDirLoader("src/main/resources/scripts/").loadConfigs();
            fieldConfigs.forEach(
                    fc -> {
                        fieldConfigMap.put(fc.getName(), fc);
                        System.out.println("add "+fc.getName()+" to map!");
                    }
            );
            System.out.println("fieldConfigs: " + fieldConfigs);
        } catch (Exception ex) {
            System.err.println("failed to load fields conf" + ex);
        }
    }

    public static ReportFieldConfig getFieldConfig(String name) {
        return fieldConfigMap.get(name);
    }

}

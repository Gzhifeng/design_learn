package com.zhifeng.common.db;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "mybatis")
public class MybatisSourceProperties {

    private String mapperLocations;

    private String typeAliasesPackage;

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }
}

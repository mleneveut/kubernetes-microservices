package io.mleneveut.kubernetes.microservices.serviceone.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Service One main settings class
 */
@ConfigurationProperties(prefix = "service-one")
public class ServiceOneSettings {
    public static String CUSTOM_PARAM_1_DEFAULT_VALUE = "Param 1 default value";

    /** A custom string parameter */
    private String customStringParam1 = CUSTOM_PARAM_1_DEFAULT_VALUE;
    /** A custom boolean parameter */
    private boolean isCustomParam2 = false;
    /** A custom int parameter */
    private int customIntParam3 = 200;

    public String getCustomStringParam1() {
        return customStringParam1;
    }

    public void setCustomStringParam1(String customStringParam1) {
        this.customStringParam1 = customStringParam1;
    }

    public boolean isCustomParam2() {
        return isCustomParam2;
    }

    public void setIsCustomParam2(boolean isCustomParam2) {
        this.isCustomParam2 = isCustomParam2;
    }

    public int getCustomIntParam3() {
        return customIntParam3;
    }

    public void setCustomIntParam3(int customIntParam3) {
        this.customIntParam3 = customIntParam3;
    }

}
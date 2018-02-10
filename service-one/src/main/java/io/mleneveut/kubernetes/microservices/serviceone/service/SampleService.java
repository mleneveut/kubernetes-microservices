package io.mleneveut.kubernetes.microservices.serviceone.service;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

import io.mleneveut.kubernetes.microservices.serviceone.settings.ServiceOneSettings;

/**
 * Sample service with dumb methods
 */
@Service
public class SampleService {

        @Inject
        private ServiceOneSettings settings;

        /**
         * Get the custom String parameter from settings
         * @return the param "customStringParam1" from settings
         */
        public String getCustomStringParamValue() {
                return settings.getCustomStringParam1();
        }

        /**
         * Get the custom boolean parameter from settings
         * @return the param "isCustomParam2" from settings
         */
        public boolean getCustomBooleanParamValue() {
                return settings.isCustomParam2();
        }
}

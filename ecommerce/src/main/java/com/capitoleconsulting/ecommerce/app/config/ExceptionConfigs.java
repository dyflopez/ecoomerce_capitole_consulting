package com.capitoleconsulting.ecommerce.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "controller")
public class ExceptionConfigs {

    private Map<String, String> exception;

    public static final String BUSINESS = "business";

    public static final String SYSTEM =  "system";

    public String getTiposExcepciones(final String tipoExcep) {
        return exception.get(tipoExcep);
    }
}

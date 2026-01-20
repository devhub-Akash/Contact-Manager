package com.scm.backend.ContactManager.config;

import com.scm.backend.ContactManager.entity.Contact;
import com.scm.backend.ContactManager.projection.UserProjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return new RepositoryRestConfigurer() {
            @Override
            public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
                config.setBasePath(AppConstants.REST_BASE_PATH);
                config.setDefaultPageSize(AppConstants.PAGE_SIZE);
                config.setDefaultMediaType(MediaType.APPLICATION_JSON);
                config.getProjectionConfiguration().addProjection(UserProjection.class);
            }
        };
    }
}

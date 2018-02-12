package spring.boot.jersey.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import spring.boot.jersey.rest.CatApi;
import spring.boot.jersey.rest.model.IllegalArgumentExceptionMapper;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(CatApi.class);
        register(DeclarativeLinkingFeature.class);
        register(IllegalArgumentExceptionMapper.class);
        configureSwagger();
    }

    public void configureSwagger() {
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("Jersey sandbox");
        beanConfig.setVersion("v1");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("spring.boot.jersey.rest");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }

}
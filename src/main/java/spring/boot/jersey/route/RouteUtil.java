package spring.boot.jersey.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

public class RouteUtil {

    public static RouteDefinition direct(RouteBuilder routeBuilder, String path) {
        return routeBuilder.from(directUri(routeBuilder.getClass(), path)).routeId(path);
    }

    public static String directUri(Class<? extends RouteBuilder> builder, String path) {
        return "direct://" + builder.getSimpleName() + path;
    }
}

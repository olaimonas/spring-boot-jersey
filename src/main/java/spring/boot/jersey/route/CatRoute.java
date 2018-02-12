package spring.boot.jersey.route;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.language.ognl.OgnlExpression.ognl;
import static spring.boot.jersey.route.RouteUtil.direct;

@Component
public class CatRoute extends SpringRouteBuilder {

    public static final String GET_CAT = "GetCat";
    public static final String SAVE_CAT = "SaveCat";
    public static final String GET_ALL_CATS = "GetAllCats";
    public static final String UPDATE_CAT = "UpdateCat";

    @Override
    public void configure() throws Exception {

        direct(this, GET_CAT).routeId(GET_CAT)
                .errorHandler(noErrorHandler())
                .log("Getting cat by id ${body}")
                .bean("catService", "getCat")
                .setHeader("CatWorld", ognl("@spring.boot.jersey.rest.model.CatUtil@talk()"))
                .setProperty("FurColor", simple("${body.name}")) // I body.name uzsetinti konstanta (kokia nors value)
                .process(exchange -> {
                    exchange.getIn().getHeader("CatWorld");
                });

        direct(this, SAVE_CAT).routeId(SAVE_CAT)
                .errorHandler(noErrorHandler())
                .log("Posting cat by id ${body.id}")
                .bean("catService", "saveCat");

        direct(this, GET_ALL_CATS).routeId(GET_ALL_CATS)
                .errorHandler(noErrorHandler())
                .log("Getting all cats ${body}")
                .bean("catService", "getAllCats");

        direct(this, UPDATE_CAT).routeId(UPDATE_CAT)
                .errorHandler(noErrorHandler())
                .log("Updating cat by id ${body}")
                .bean("catService", "updateCat");
    }
}

package spring.boot.jersey.rest;

import io.swagger.annotations.*;
import io.swagger.jaxrs.PATCH;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.boot.jersey.rest.model.Cat;
import spring.boot.jersey.rest.model.Helper;
import spring.boot.jersey.rest.model.PageRequest;
import spring.boot.jersey.route.CatRoute;
import spring.boot.jersey.service.CatRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static spring.boot.jersey.route.RouteUtil.directUri;

@Path("cats")
@Api(value = "/api/cats", tags = "Cats API")
@Component
public class CatApi {

    @Autowired
    private ProducerTemplate producerTemplate;

    @GET
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Such cat does not exist"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiOperation(
            value = "",
            notes = "",
            response = Cat.class)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getCat(@PathParam("id") Long id) {
        return Response.ok(producerTemplate.requestBody(directUri(CatRoute.class, CatRoute.GET_CAT), id, Cat.class)).build();
    }

    @GET
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Such cat does not exist"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiOperation(
            value = "",
            notes = "",
            response = Cat.class,
            responseContainer = "List")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCats(@ApiParam(value = "Number of items to retrieve. Default is 5.")
                               @QueryParam("offset") Integer offset, @QueryParam("size") Integer size) {
        return Response.ok(producerTemplate.requestBody(directUri(CatRoute.class, CatRoute.GET_ALL_CATS), new PageRequest(offset, size), List.class)).build();
    }

    @POST
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Such cat does not exist"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiOperation(
            value = "",
            notes = "",
            response = Cat.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveCat(CatRequest catRequest) {
        producerTemplate.requestBody(directUri(CatRoute.class, CatRoute.SAVE_CAT), catRequest, Cat.class);
        Helper helper = new Helper();
        helper.setId(catRequest.getId());
        return Response.ok(helper).build();
    }

    @PATCH
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Such cat does not exist"),
            @ApiResponse(code = 500, message = "Internal server error")
    })
    @ApiOperation(
            value = "",
            notes = "",
            response = Cat.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCat(CatRequest catRequest) {
        producerTemplate.requestBody(directUri(CatRoute.class, CatRoute.UPDATE_CAT), catRequest, Cat.class);
        Helper helper = new Helper();
        helper.setId(catRequest.getId());
        return Response.ok(helper).build();
    }
}

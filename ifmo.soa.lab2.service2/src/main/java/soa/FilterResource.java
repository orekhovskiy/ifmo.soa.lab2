package soa;

import soa.models.ProductsList;

import javax.ws.rs.client.Invocation.Builder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/filter")
public class FilterResource {
    @GET
    @Path("/{name}")
    public Response getMsg(@PathParam("name") String name) {
        String output = "Welcome   : " + name;
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/manufacture-cost/{manufacture-cost}")
    @Produces("application/xml")
    public Response getFilteredByManufactureCost(@PathParam("manufacture-cost") String cost) {
        return FilterService.getFilteredProducts("manufacture-cost", cost);
    }

    @GET
    @Path("/unit-of-measure/{unit-of-measure}")
    @Produces("application/xml")
    public Response getFilteredByUnitOfMeasure(@PathParam("unit-of-measure") String unitOfMeasure) {
        return FilterService.getFilteredProducts("unit-of-measure", unitOfMeasure);
    }
}
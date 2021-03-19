package soa;


import soa.models.ProductsList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class FilterService {
    private static final Client client = ClientBuilder.newBuilder().build();
    private static final String REST_URI = System.getenv("soa_service1_url");

    public static Response getFilteredProducts(String resource, String value) {
        try {
            ProductsList res =  client
                    .target(REST_URI + "?" + resource + "=" + value)
                    .request(MediaType.APPLICATION_XML)
                    .get(ProductsList.class);
            return Response.status(Response.Status.OK).entity(res).build();
        }
        catch (Exception e) {
            return client
                    .target(REST_URI + "?" + resource + "=" + value)
                    .request(MediaType.APPLICATION_XML).get();
        }
    }
}

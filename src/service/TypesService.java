package service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import model.TypesManager;

import dto.Types;

@Path("/types")
public class TypesService{
    @GET
    @Produces("application/json")
    public Response types() {
        Gson gson = new Gson();
        String typesResult = null;
        Status status = Response.Status.OK;        
        ArrayList<Types> typesList = new ArrayList<Types>();
        try {
            typesList = new TypesManager().getTypes();
        } catch (Exception e) {
            e.printStackTrace();
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }
        typesResult = gson.toJson(typesList);
        return Response.status(status)
            .entity(typesResult).build();
    }
}

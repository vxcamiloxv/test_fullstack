package service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;

import com.google.gson.Gson;

import model.InventoryManager;

import dto.Inventory;

@Path("/inventorys")
public class InventoryService{
    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response inventory(@PathParam("id") int id) {
    	Gson gson = new Gson();
    	String inventoryResult = null;
    	Status status = Response.Status.OK;
        Object inventory = new Object();
        
        try {
            inventory = new InventoryManager().getInventory(id);      
            if(inventory == null) {
            	inventory = new Object();
            	status = Response.Status.NOT_FOUND;
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }
        inventoryResult = gson.toJson(inventory);
        return Response.status(status)
    			.entity(inventoryResult).build();
    }
    @GET
    @Produces("application/json")
    public Response inventorys() {
        Gson gson = new Gson(); 
    	String inventoryResult = null;
    	Status status = Response.Status.OK;
        ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
        
        try {
            inventoryList = new InventoryManager().getInventorys();  
        } catch (Exception e) {
            e.printStackTrace();
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }
        
        inventoryResult = gson.toJson(inventoryList);
        return Response.status(status)
    			.entity(inventoryResult).build();
    }
    
    @POST
    @Produces("application/json")
    public Response createInventory(@QueryParam("name") String name,
    		@QueryParam("description") String description,
    		@QueryParam("type_id") int type_id,
    		@QueryParam("unit_price") Double unit_price) {
        Gson gson = new Gson(); 
      	String inventoryResult = null;
      	Status status = Response.Status.OK;
        Object inventory = new ArrayList<Inventory>();
        try {
            inventory = new InventoryManager().createInventory(
            		name, 
            		description, 
            		type_id, 
            		unit_price);
        } catch (Exception e) {
            e.printStackTrace();
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }
        inventoryResult = gson.toJson(inventory);
        return Response.status(status)
    			.entity(inventoryResult).build();
    }
    
    @PUT
    @Path("{id}")
    @Produces("application/json")
    public Response putInventory(@PathParam("id") int id,
    		@QueryParam("name") String name,
    		@QueryParam("description") String description,
    		@QueryParam("type_id") int type_id,
    		@QueryParam("unit_price") Double unit_price) {
    	Gson gson = new Gson();
      	String inventoryResult = null;
      	Status status = Response.Status.OK;
    	Object inventory = new Inventory();
        try {
            inventory = new InventoryManager().putInventory(
            	    id, 
            		name, 
            		description, 
            		type_id, 
            		unit_price);
            if(inventory == null) {
            	inventory = new Object();
            	status = Response.Status.NOT_FOUND;
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }
        inventoryResult = gson.toJson(inventory);
        return Response.status(status)
    			.entity(inventoryResult).build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response deleteInventory(@PathParam("id") int id) {
    	Gson gson = new Gson();
      	String inventoryResult = null;
      	Status status = Response.Status.OK;
    	Object inventory = new Inventory();
        try {
            inventory = new InventoryManager().deleteInventory(id);
            if(inventory == null) {
            	inventory = new Object();
            	status = Response.Status.NOT_FOUND;
            }            
        } catch (Exception e) {
            e.printStackTrace();
            status = Response.Status.INTERNAL_SERVER_ERROR;
        }
        inventoryResult = gson.toJson(inventory);
        return Response.status(status)
    			.entity(inventoryResult).build();
    }
}

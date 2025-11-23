package com.example.Benchmark.controller;

import com.example.Benchmark.entity.Item;
import com.example.Benchmark.service.ItemService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/items")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }

    @GET
    public List<Item> getAll(@QueryParam("page") @DefaultValue("1") int page,
                             @QueryParam("size") @DefaultValue("20") int size) {
        return service.getItems(page, size);
    }

    @GET
    @Path("/{id}")
    public Item getById(@PathParam("id") Long id) {
        return service.getItem(id);
    }

    @GET
    public List<Item> getByCategory(@QueryParam("categoryId") Long categoryId,
                                    @QueryParam("page") @DefaultValue("1") int page,
                                    @QueryParam("size") @DefaultValue("20") int size) {
        if (categoryId == null) {
            return service.getItems(page, size);
        }
        return service.getItemsByCategory(categoryId, page, size);
    }

    @POST
    public Response create(Item item) {
        service.createItem(item);
        return Response.status(Response.Status.CREATED).entity(item).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Item item) {
        item.setId(id);
        service.updateItem(item);
        return Response.ok(item).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Item item = service.getItem(id);
        service.deleteItem(item);
        return Response.noContent().build();
    }
}

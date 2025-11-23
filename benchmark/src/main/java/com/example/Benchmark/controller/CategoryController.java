package com.example.Benchmark.controller;


import com.example.Benchmark.entity.Category;
import com.example.Benchmark.service.CategoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryController {

    private CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GET
    public List<Category> getAll(@QueryParam("page") @DefaultValue("1") int page,
                                 @QueryParam("size") @DefaultValue("20") int size) {
        return service.getCategories(page, size);
    }

    @GET
    @Path("/{id}")
    public Category getById(@PathParam("id") Long id) {
        return service.getCategory(id);
    }

    @POST
    public Response create(Category category) {
        service.createCategory(category);
        return Response.status(Response.Status.CREATED).entity(category).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Category category) {
        category.setId(id);
        service.updateCategory(category);
        return Response.ok(category).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Category category = service.getCategory(id);
        service.deleteCategory(category);
        return Response.noContent().build();
    }
}

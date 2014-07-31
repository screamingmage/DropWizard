package com.example.dropwizard.resource;

import com.example.dropwizard.dao.TodoItemDao;
import com.example.dropwizard.dto.TodoItem;
import com.example.dropwizard.view.FreeMarkerView;
import io.dropwizard.views.View;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 31/07/2014
 * Time: 17:39
 * To change this template use File | Settings | File Templates.
 */

@Path("/todo")
public class TodoResource {

    private final TodoItemDao todoItemDao;

    public TodoResource(TodoItemDao todoItemDao) {
        this.todoItemDao = todoItemDao;
    }

    @GET
    @Path("/items")
    @Produces(MediaType.TEXT_HTML)
    public View list() {
        return new FreeMarkerView("todo", new Object());
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid TodoItem todoItem) {
        todoItemDao.save(todoItem);
        return Response.noContent().build();
    }

    @GET
    @Path("/list/items")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TodoItem> listItems() {
        final Iterable<TodoItem> all = todoItemDao.all();
        List<TodoItem> items = new ArrayList<TodoItem>();
        for(TodoItem item : all) {
            items.add(item);
        }
        return items;
    }
}

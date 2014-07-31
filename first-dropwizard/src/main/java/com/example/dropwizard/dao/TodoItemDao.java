package com.example.dropwizard.dao;

import com.example.dropwizard.configuration.FirstDropWizardConfiguration;
import com.example.dropwizard.dto.TodoItem;
import com.mongodb.*;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sully.rafiq
 * Date: 31/07/2014
 * Time: 21:59
 * To change this template use File | Settings | File Templates.
 */
public class TodoItemDao {

    private final DB db;

    public TodoItemDao(FirstDropWizardConfiguration configuration) throws UnknownHostException {
        MongoClientURI uri = new MongoClientURI("mongodb://msm:password@ds053439.mongolab.com:53439/msm");
        db = new MongoClient(uri).getDB("msm");
    }

    public void save(TodoItem todoItem) {
        final Jongo jongo = new Jongo(db);
        final MongoCollection itemCollection = jongo.getCollection("itemCollection");
        itemCollection.save(todoItem);
    }

    public Iterable<TodoItem> all() {
        final Jongo jongo = new Jongo(db);
        final MongoCollection itemCollection = jongo.getCollection("itemCollection");
        return itemCollection.find().as(TodoItem.class);
    }

}

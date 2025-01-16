package Interfaces;

import Request.ResourceData;

import java.util.concurrent.ConcurrentHashMap;

public interface Body<T> {

    public ConcurrentHashMap<String, ResourceData<T>> resources();

}

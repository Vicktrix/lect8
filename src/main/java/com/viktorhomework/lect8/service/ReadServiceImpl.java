package com.viktorhomework.lect8.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service("read")
public class ReadServiceImpl implements ReadService{
    private ResourceLoader resourceLoader;
    
    @Autowired
    public ReadServiceImpl(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }
    
    @Override
    public String getString(String str){
        Resource resource = resourceLoader.getResource(str);
        String page = null;
        try{
            page=Files.readString(resource.getFile().toPath(), StandardCharsets.UTF_8);
        }catch(IOException ex){
            System.out.println("Error in getResource from "+str+"\n "+ex);
            page = "page = null";
        }
        return page;
    }
}
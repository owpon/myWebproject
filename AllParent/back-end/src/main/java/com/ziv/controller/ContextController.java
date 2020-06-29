package com.ziv.controller;

import com.ziv.config.JSONResult;
import com.ziv.dao.imember.IContextRepo;
import com.ziv.entity.ContextEntity;
import com.ziv.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ContextController {
    @Autowired
    IContextRepo iContextRepo;

    // get All context
    @GetMapping("/getAllContext")
    public List<ContextEntity> getAllContext() {
        List<ContextEntity> contextData = new ArrayList<ContextEntity>();
        contextData = iContextRepo.findAll();
        return contextData;
    }

    // create new context
    @PostMapping("/createContext")
    public ContextEntity createContext(@RequestBody ContextEntity contextEntity) {
        return iContextRepo.save(contextEntity);
    }

    // edit context
    @PostMapping("/editContext")
    public void editContext(@RequestBody ContextEntity contextEntity) {
        Date date = new Date();

        contextEntity.setAuther(contextEntity.getAuther());
        contextEntity.setCreateTime(contextEntity.getCreateTime());
        contextEntity.setUpdateTime(date);
        contextEntity.setContext(contextEntity.getContext());
        iContextRepo.save(contextEntity);
    }

    // get single context
    @GetMapping("/context/{id}")
    public ContextEntity getOneContext(@PathVariable(value = "id") Long contextId) {
        return iContextRepo.findById(contextId).orElseThrow(() -> new ResourceNotFoundException("context", "id", contextId));
    }

    // delete context
    @DeleteMapping("/delete/{id}")
    public String deleteContext(@PathVariable(value = "id") ContextEntity contextEntity) {
        iContextRepo.delete(contextEntity);
        return "data delete";
    }

    @PostMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public String usersList() {

        ArrayList<String> users = new ArrayList<String>() {
            {
                add("freewolf");
                add("tom");
                add("jerry");
            }
        };

        return JSONResult.fillResultString(0, "", users);
    }

}

package com.ziv.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ziv.dao.imember.IContextRepo;
import com.ziv.entity.ContextEntity;
import com.ziv.exception.ResourceNotFoundException;

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
	public ContextEntity createContext(@Valid @RequestBody ContextEntity contextEntity) {
		return iContextRepo.save(contextEntity);
	}

	// edit context
	@PostMapping("/editContext")
	public void editContext(@Valid @RequestBody ContextEntity contextEntity) {
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
	@PostMapping("/delete")
	public List<ContextEntity> deleteContext(@Valid @RequestBody ContextEntity contextEntity) {
		iContextRepo.delete(contextEntity);
		List<ContextEntity> contextData = new ArrayList<ContextEntity>();
		contextData = iContextRepo.findAll();
		return contextData;
	}
}

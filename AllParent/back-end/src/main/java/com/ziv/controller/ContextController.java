package com.ziv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ziv.dao.imember.IContextRepo;
import com.ziv.entity.ContextEntity;

@RestController
public class ContextController {
	@Autowired
	IContextRepo iContextRepo;

	@GetMapping("/getAllContext")
	public List<ContextEntity> getAllContext() {
		List<ContextEntity> contextData = new ArrayList<ContextEntity>();
		contextData = iContextRepo.findAll();
		return contextData;
	}
}

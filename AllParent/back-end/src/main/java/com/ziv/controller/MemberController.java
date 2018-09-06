package com.ziv.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ziv.dao.imember.IMemberRepo;
import com.ziv.entity.MemberEntity;

@RestController
//@CrossOrigin("http://localhost:8080")
public class MemberController {
	@Autowired
	IMemberRepo imemberRepo;

	// 測試api是否會通
	@GetMapping("/hi")
	public String sayHi() {
		System.out.println("hi");
		return "hello";
	}

	@GetMapping("/getAllMember")
	public List<MemberEntity> getAllMember() {
		List<MemberEntity> memberBean = new ArrayList<MemberEntity>();
		memberBean = imemberRepo.findAll();
		return memberBean;
	}

	@PostMapping("/doLogin")
	public String login(@RequestBody MemberEntity memberEntity) {
		System.out.println(memberEntity.getEmail());
		System.out.println(imemberRepo.findByEmail(memberEntity.getEmail(), memberEntity.getPassword()));
		return "hello";
	}
}

package com.ziv.dao.imember;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ziv.entity.ContextEntity;

public interface IContextRepo extends JpaRepository<ContextEntity, Long> {
    //因為是使用jpa所以不需實作
    List<ContextEntity> findAll();
}

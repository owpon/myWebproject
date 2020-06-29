//package com.ziv.dao.imember;
//
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import com.ziv.entity.MemberEntity;
//
//public interface IMemberRepo extends JpaRepository<MemberEntity, Long> {
//	List<MemberEntity> findAll();
//
//	@Query(value = "select id,email,cellphone,password from MemberEntity m where m.email=?1 and m.password=?2")
//	List<MemberEntity> findByEmail(String email, String password);
//}

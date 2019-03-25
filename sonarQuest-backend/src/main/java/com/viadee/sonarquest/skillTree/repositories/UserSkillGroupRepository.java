package com.viadee.sonarquest.skillTree.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.viadee.sonarquest.skillTree.entities.UserSkillGroup;

public interface UserSkillGroupRepository extends JpaRepository<UserSkillGroup, Long>{
	
	 @Query("SELECT u FROM UserSkillGroup u WHERE isRoot = :isRoot")
	    public List<UserSkillGroup> findAllRootUserSkillGroups(@Param("isRoot") boolean isRoot);

}

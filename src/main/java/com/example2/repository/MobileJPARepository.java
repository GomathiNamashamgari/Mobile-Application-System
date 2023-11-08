package com.example2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example2.model.Mobile;

public interface MobileJPARepository extends JpaRepository<Mobile, Integer>
{
	
}

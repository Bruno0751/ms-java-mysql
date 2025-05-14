package com.dev.ms_java_mysql.repositories;

import com.dev.ms_java_mysql.models.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel, Long> {
}

package com.dev.ms_java_mysql.v1.fregues.api.repositorie;

import com.dev.ms_java_mysql.v1.fregues.api.model.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel, Long> {
}

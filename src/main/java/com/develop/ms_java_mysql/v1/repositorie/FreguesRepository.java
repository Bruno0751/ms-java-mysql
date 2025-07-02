package com.develop.ms_java_mysql.v1.repositorie;

import com.develop.ms_java_mysql.v1.model.FreguesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreguesRepository extends JpaRepository<FreguesModel, Long>{
}

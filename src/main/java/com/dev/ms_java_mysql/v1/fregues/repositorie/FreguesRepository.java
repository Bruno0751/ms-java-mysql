package com.dev.ms_java_mysql.v1.fregues.repositorie;

import com.dev.ms_java_mysql.v1.fregues.model.FreguesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreguesRepository extends JpaRepository<FreguesModel, Long>{
}

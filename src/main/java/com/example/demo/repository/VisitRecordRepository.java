package com.example.demo.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.VisitRecord;
@Repository
public interface VisitRecordRepository extends JpaRepository<VisitRecord,Long>{
    

}

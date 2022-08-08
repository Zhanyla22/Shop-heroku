package com.zhanko.learningSpring.repository;

import com.zhanko.learningSpring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Employee, Integer> {

}

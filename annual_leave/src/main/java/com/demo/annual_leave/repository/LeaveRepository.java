package com.demo.annual_leave.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Leave;


public interface LeaveRepository extends JpaRepository<Leave, Integer>{

    Leave findLeaveById(int id);

    Leave createLeave(Leave leave);

    Leave updateLeave(Leave leave);

    String deleteLeave(int id);
    
}

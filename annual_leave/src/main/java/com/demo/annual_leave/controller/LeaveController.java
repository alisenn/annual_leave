package com.demo.annual_leave.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.annual_leave.repository.LeaveRepository;
import com.demo.model.Leave;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/leave")
@CrossOrigin(origins = "http://localhost:8080")
public class LeaveController {

    @Autowired
    private LeaveRepository leaveRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Leave> getLeave(@PathVariable("id") int id) {
        Optional<Leave> leaveData = leaveRepository.findById(id);

        if (leaveData.isPresent()) {
            return new ResponseEntity<>(leaveData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
    
    @PostMapping("")
    public ResponseEntity<Leave> createLeave(@RequestBody Leave leave) {
        try {
            Leave _leave = leaveRepository
                    .createLeave(new Leave(leave.getWantedLeaveDays(), null, leave.getLeftLeaveDays()));
            return new ResponseEntity<>(_leave, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Leave> updateLeave(@PathVariable("id") int id, @RequestBody Leave leave) {
        Optional<Leave> leaveData = leaveRepository.findById(id);

        if (leaveData.isPresent()) {
            Leave _leave = leaveData.get();
            _leave.setWantedLeaveDays(leave.getWantedLeaveDays());
            _leave.setWantedLeaveStatus(leave.getWantedLeaveStatus());
            _leave.setLeftLeaveDays(leave.getLeftLeaveDays());
            return new ResponseEntity<>(leaveRepository.updateLeave(_leave), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLeave(@PathVariable("id") int id) {
        try {
            leaveRepository.deleteLeave(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

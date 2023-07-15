package com.demo.model;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Entity
@Table(name = "leave")
@Getter 
@Setter
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "wanted_leave_days")
    private int wantedLeaveDays;

    @Column(name = "wanted_leave_status")
    private Boolean wantedLeaveStatus;

    @Column(name = "left_leave_days")
    private int leftLeaveDays;

    public Leave() {
    }

    public Leave(int wantedLeaveDays, Boolean wantedLeaveStatus, int leftLeaveDays) {
        this.wantedLeaveDays = wantedLeaveDays;
        this.wantedLeaveStatus = wantedLeaveStatus;
        this.leftLeaveDays = leftLeaveDays;
    }




    
}

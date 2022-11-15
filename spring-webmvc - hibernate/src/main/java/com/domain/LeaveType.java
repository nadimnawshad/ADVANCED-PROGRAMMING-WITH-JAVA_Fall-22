package com.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "LeaveType")
public class LeaveType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "leave_id")
    private LeaveApplication leave_id;

    @ManyToOne
    @JoinColumn(name = "leave_id")
    private LeaveApplication totalDays;

    private String category;

    public LeaveApplication getTotalDays() {
        return totalDays;
    }
}

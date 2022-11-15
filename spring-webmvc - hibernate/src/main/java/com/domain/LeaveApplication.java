package com.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "leaveApplication")
public class LeaveApplication {
    @Id
    @Column(name = "leave_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee_id;

    private LocalDate fromLeaveDate;

    private LocalDate toLeaveDate;

    private int totalLeaveDays;

    private  String reason;

    public void setFromLeaveDate(LocalDate fromLeaveDate) {
        this.fromLeaveDate = fromLeaveDate;
    }

    public LocalDate getFromLeaveDate() {
        return fromLeaveDate;
    }

    public void setToLeaveDate(LocalDate toLeaveDate) {
        this.toLeaveDate = toLeaveDate;
    }

    public LocalDate getToLeaveDate() {
        return toLeaveDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}

package com.example.dashboard.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "metric_snapshots")
public class MetricSnapshot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate periodStart;
    private LocalDate periodEnd;
    private Integer badgesEarned;
    private Integer pointsEarned;
    private Integer assignmentsSubmitted;
    private Integer inactivityDays;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public LocalDate getPeriodStart() { return periodStart; }
    public void setPeriodStart(LocalDate periodStart) { this.periodStart = periodStart; }
    public LocalDate getPeriodEnd() { return periodEnd; }
    public void setPeriodEnd(LocalDate periodEnd) { this.periodEnd = periodEnd; }
    public Integer getBadgesEarned() { return badgesEarned; }
    public void setBadgesEarned(Integer badgesEarned) { this.badgesEarned = badgesEarned; }
    public Integer getPointsEarned() { return pointsEarned; }
    public void setPointsEarned(Integer pointsEarned) { this.pointsEarned = pointsEarned; }
    public Integer getAssignmentsSubmitted() { return assignmentsSubmitted; }
    public void setAssignmentsSubmitted(Integer assignmentsSubmitted) { this.assignmentsSubmitted = assignmentsSubmitted; }
    public Integer getInactivityDays() { return inactivityDays; }
    public void setInactivityDays(Integer inactivityDays) { this.inactivityDays = inactivityDays; }
}

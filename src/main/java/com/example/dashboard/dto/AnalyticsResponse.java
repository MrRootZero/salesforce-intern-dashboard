package com.example.dashboard.dto;

public class AnalyticsResponse {
    private Integer badgesEarned;
    private Integer pointsEarned;
    private Integer assignmentsSubmitted;
    private Integer inactivityDays;

    // getters and setters
    public Integer getBadgesEarned() { return badgesEarned; }
    public void setBadgesEarned(Integer badgesEarned) { this.badgesEarned = badgesEarned; }
    public Integer getPointsEarned() { return pointsEarned; }
    public void setPointsEarned(Integer pointsEarned) { this.pointsEarned = pointsEarned; }
    public Integer getAssignmentsSubmitted() { return assignmentsSubmitted; }
    public void setAssignmentsSubmitted(Integer assignmentsSubmitted) { this.assignmentsSubmitted = assignmentsSubmitted; }
    public Integer getInactivityDays() { return inactivityDays; }
    public void setInactivityDays(Integer inactivityDays) { this.inactivityDays = inactivityDays; }
}

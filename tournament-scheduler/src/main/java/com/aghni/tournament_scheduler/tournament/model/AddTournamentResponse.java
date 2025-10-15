package com.aghni.tournament_scheduler.tournament.model;

import java.time.LocalDate;

public class AddTournamentResponse {

    private LocalDate date;
    private String message;
    private String status;

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public AddTournamentResponse() {

    }

    public AddTournamentResponse(LocalDate date, String message,String status) {
        this.date = date;
        this.message = message;
        this.status = status;
    }
}

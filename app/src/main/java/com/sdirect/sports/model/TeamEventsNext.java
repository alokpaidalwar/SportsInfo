package com.sdirect.sports.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamEventsNext {
    @SerializedName("events")
    @Expose
    private ArrayList<Event> events = null;

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }


    public class Event {


        @SerializedName("strHomeTeam")
        @Expose
        private String strHomeTeam;
        @SerializedName("strAwayTeam")
        @Expose
        private String strAwayTeam;
        @SerializedName("strDate")
        @Expose
        private String strDate;
        @SerializedName("strTime")
        @Expose
        private String strTime;
        @SerializedName("strSport")
        @Expose
        private String strSport;
        @SerializedName("strLeague")
        @Expose
        private String strLeague;
        @SerializedName("dateEvent")
        @Expose
        private String strdateEvent;
        @SerializedName("intHomeScore")
        @Expose
        private String intHomeScore;
        @SerializedName("intAwayScore")
        @Expose
        private String intAwayScore;

        public String getStrHomeTeam() {
            return strHomeTeam;
        }

        public void setStrHomeTeam(String strHomeTeam) {
            this.strHomeTeam = strHomeTeam;
        }

        public String getStrAwayTeam() {
            return strAwayTeam;
        }

        public void setStrAwayTeam(String strAwayTeam) {
            this.strAwayTeam = strAwayTeam;
        }

        public void setIntHomeScore(String intHomeScore) {
            this.intHomeScore = intHomeScore;
        }

        public void setIntAwayScore(String intAwayScore) {
            this.intAwayScore = intAwayScore;
        }

        public String getIntHomeScore() {
            return intHomeScore;
        }

        public String getIntAwayScore() {
            return intAwayScore;
        }

        public String getStrdateEvent() {
            return strdateEvent;
        }

        public void setStrdateEvent(String strdateEvent) {
            this.strdateEvent = strdateEvent;
        }

        public String getStrLeague() {
            return strLeague;
        }

        public void setStrLeague(String strLeague) {
            this.strLeague = strLeague;
        }

        public String getStrSport() {
            return strSport;
        }

        public void setStrSport(String strSport) {
            this.strSport = strSport;
        }

        public String getStrDate() {
            return strDate;
        }

        public void setStrDate(String strDate) {
            this.strDate = strDate;
        }

        public String getStrTime() {
            return strTime;
        }

        public void setStrTime(String strTime) {
            this.strTime = strTime;
        }

    }
}

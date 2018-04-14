package com.sdirect.sports.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Results {

    @SerializedName("results")
    @Expose
    private ArrayList<Result> results = null;

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public class Result {


        @SerializedName("strHomeTeam")
        @Expose
        private String strHomeTeam;
        @SerializedName("strAwayTeam")
        @Expose
        private String strAwayTeam;
        @SerializedName("strSport")
        @Expose
        private String strSport;
        @SerializedName("strLeague")
        @Expose
        private String strLeague;
        @SerializedName("intHomeScore")
        @Expose
        private String intHomeScore;
        @SerializedName("intAwayScore")
        @Expose
        private String intAwayScore;
        @SerializedName("dateEvent")
        @Expose
        private String dateEvent;
        @SerializedName("strDate")
        @Expose
        private String strDate;
        @SerializedName("strTime")
        @Expose
        private String strTime;


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

        public String getStrSport() {
            return strSport;
        }

        public void setStrSport(String strSport) {
            this.strSport = strSport;
        }

        public String getStrLeague() {
            return strLeague;
        }

        public void setStrLeague(String strLeague) {
            this.strLeague = strLeague;
        }

        public String getIntHomeScore() {
            return intHomeScore;
        }

        public void setIntHomeScore(String intHomeScore) {
            this.intHomeScore = intHomeScore;
        }

        public String getIntAwayScore() {
            return intAwayScore;
        }

        public void setIntAwayScore(String intAwayScore) {
            this.intAwayScore = intAwayScore;
        }

        public String getDateEvent() {
            return dateEvent;
        }

        public void setDateEvent(String dateEvent) {
            this.dateEvent = dateEvent;
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

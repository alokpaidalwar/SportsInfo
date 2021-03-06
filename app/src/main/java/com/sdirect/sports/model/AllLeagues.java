package com.sdirect.sports.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllLeagues {

    @SerializedName("leagues")
    @Expose
    private ArrayList<League> leagues = null;

    public ArrayList<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(ArrayList<League> leagues) {
        this.leagues = leagues;
    }


    public class League {

        @SerializedName("idLeague")
        @Expose
        private String idLeague;
        @SerializedName("strLeague")
        @Expose
        private String strLeague;
        @SerializedName("strSport")
        @Expose
        private String strSport;
        @SerializedName("strLeagueAlternate")
        @Expose
        private String strLeagueAlternate;

        public String getIdLeague() {
            return idLeague;
        }

        public void setIdLeague(String idLeague) {
            this.idLeague = idLeague;
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

        public String getStrLeagueAlternate() {
            return strLeagueAlternate;
        }

        public void setStrLeagueAlternate(String strLeagueAlternate) {
            this.strLeagueAlternate = strLeagueAlternate;
        }

    }
}

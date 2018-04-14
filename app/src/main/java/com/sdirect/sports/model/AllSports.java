package com.sdirect.sports.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllSports {

    @SerializedName("sports")
    @Expose
    private ArrayList<Sport> sports = null;

    public ArrayList<Sport> getSports() {
        return sports;
    }

    public void setSports(ArrayList<Sport> sports) {
        this.sports = sports;
    }

    public class Sport {

        @SerializedName("idSport")
        @Expose
        private String idSport;
        @SerializedName("strSport")
        @Expose
        private String strSport;
        @SerializedName("strSportThumb")
        @Expose
        private String strSportThumb;
        @SerializedName("strSportDescription")
        @Expose
        private String strSportDescription;

        public String getIdSport() {
            return idSport;
        }

        public void setIdSport(String idSport) {
            this.idSport = idSport;
        }

        public String getStrSport() {
            return strSport;
        }

        public void setStrSport(String strSport) {
            this.strSport = strSport;
        }

        public String getStrSportThumb() {
            return strSportThumb;
        }

        public void setStrSportThumb(String strSportThumb) {
            this.strSportThumb = strSportThumb;
        }

        public String getStrSportDescription() {
            return strSportDescription;
        }

        public void setStrSportDescription(String strSportDescription) {
            this.strSportDescription = strSportDescription;
        }

    }
}

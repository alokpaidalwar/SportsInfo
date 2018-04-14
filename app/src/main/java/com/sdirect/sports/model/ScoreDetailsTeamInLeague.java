package com.sdirect.sports.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ScoreDetailsTeamInLeague {
    @SerializedName("table")
    @Expose
    private ArrayList<Table> table = null;

    public ArrayList<Table> getTable() {
        return table;
    }

    public void setTable(ArrayList<Table> table) {
        this.table = table;
    }

    public class Table {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("teamid")
        @Expose
        private String teamid;
        @SerializedName("played")
        @Expose
        private Integer played;
        @SerializedName("goalsfor")
        @Expose
        private Integer goalsfor;
        @SerializedName("goalsagainst")
        @Expose
        private Integer goalsagainst;
        @SerializedName("goalsdifference")
        @Expose
        private Integer goalsdifference;
        @SerializedName("win")
        @Expose
        private Integer win;
        @SerializedName("draw")
        @Expose
        private Integer draw;
        @SerializedName("loss")
        @Expose
        private Integer loss;
        @SerializedName("total")
        @Expose
        private Integer total;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTeamid() {
            return teamid;
        }

        public void setTeamid(String teamid) {
            this.teamid = teamid;
        }

        public Integer getPlayed() {
            return played;
        }

        public void setPlayed(Integer played) {
            this.played = played;
        }

        public Integer getGoalsfor() {
            return goalsfor;
        }

        public void setGoalsfor(Integer goalsfor) {
            this.goalsfor = goalsfor;
        }

        public Integer getGoalsagainst() {
            return goalsagainst;
        }

        public void setGoalsagainst(Integer goalsagainst) {
            this.goalsagainst = goalsagainst;
        }

        public Integer getGoalsdifference() {
            return goalsdifference;
        }

        public void setGoalsdifference(Integer goalsdifference) {
            this.goalsdifference = goalsdifference;
        }

        public Integer getWin() {
            return win;
        }

        public void setWin(Integer win) {
            this.win = win;
        }

        public Integer getDraw() {
            return draw;
        }

        public void setDraw(Integer draw) {
            this.draw = draw;
        }

        public Integer getLoss() {
            return loss;
        }

        public void setLoss(Integer loss) {
            this.loss = loss;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

    }
}

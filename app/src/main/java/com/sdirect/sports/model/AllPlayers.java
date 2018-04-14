package com.sdirect.sports.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllPlayers {

    @SerializedName("player")
    @Expose
    private ArrayList<Player> player = null;

    public ArrayList<Player> getPlayer() {
        return player;
    }

    public void setPlayer(ArrayList<Player> player) {
        this.player = player;
    }

    public class Player {

        @SerializedName("idPlayer")
        @Expose
        private String idPlayer;
        @SerializedName("idTeam")
        @Expose
        private String idTeam;
        @SerializedName("idSoccerXML")
        @Expose
        private String idSoccerXML;
        @SerializedName("idPlayerManager")
        @Expose
        private Object idPlayerManager;
        @SerializedName("strNationality")
        @Expose
        private String strNationality;
        @SerializedName("strPlayer")
        @Expose
        private String strPlayer;
        @SerializedName("strTeam")
        @Expose
        private String strTeam;
        @SerializedName("strSport")
        @Expose
        private String strSport;
        @SerializedName("intSoccerXMLTeamID")
        @Expose
        private String intSoccerXMLTeamID;
        @SerializedName("dateBorn")
        @Expose
        private String dateBorn;
        @SerializedName("dateSigned")
        @Expose
        private String dateSigned;
        @SerializedName("strSigning")
        @Expose
        private String strSigning;
        @SerializedName("strWage")
        @Expose
        private String strWage;
        @SerializedName("strBirthLocation")
        @Expose
        private String strBirthLocation;
        @SerializedName("strDescriptionEN")
        @Expose
        private String strDescriptionEN;
        @SerializedName("strDescriptionDE")
        @Expose
        private Object strDescriptionDE;
        @SerializedName("strDescriptionFR")
        @Expose
        private Object strDescriptionFR;
        @SerializedName("strDescriptionCN")
        @Expose
        private Object strDescriptionCN;
        @SerializedName("strDescriptionIT")
        @Expose
        private Object strDescriptionIT;
        @SerializedName("strDescriptionJP")
        @Expose
        private Object strDescriptionJP;
        @SerializedName("strDescriptionRU")
        @Expose
        private Object strDescriptionRU;
        @SerializedName("strDescriptionES")
        @Expose
        private Object strDescriptionES;
        @SerializedName("strDescriptionPT")
        @Expose
        private Object strDescriptionPT;
        @SerializedName("strDescriptionSE")
        @Expose
        private Object strDescriptionSE;
        @SerializedName("strDescriptionNL")
        @Expose
        private Object strDescriptionNL;
        @SerializedName("strDescriptionHU")
        @Expose
        private Object strDescriptionHU;
        @SerializedName("strDescriptionNO")
        @Expose
        private Object strDescriptionNO;
        @SerializedName("strDescriptionIL")
        @Expose
        private Object strDescriptionIL;
        @SerializedName("strDescriptionPL")
        @Expose
        private Object strDescriptionPL;
        @SerializedName("strGender")
        @Expose
        private String strGender;
        @SerializedName("strPosition")
        @Expose
        private String strPosition;
        @SerializedName("strCollege")
        @Expose
        private Object strCollege;
        @SerializedName("strFacebook")
        @Expose
        private String strFacebook;
        @SerializedName("strWebsite")
        @Expose
        private String strWebsite;
        @SerializedName("strTwitter")
        @Expose
        private String strTwitter;
        @SerializedName("strInstagram")
        @Expose
        private String strInstagram;
        @SerializedName("strYoutube")
        @Expose
        private String strYoutube;
        @SerializedName("strHeight")
        @Expose
        private String strHeight;
        @SerializedName("strWeight")
        @Expose
        private String strWeight;
        @SerializedName("intLoved")
        @Expose
        private String intLoved;
        @SerializedName("strThumb")
        @Expose
        private String strThumb;
        @SerializedName("strCutout")
        @Expose
        private String strCutout;
        @SerializedName("strFanart1")
        @Expose
        private String strFanart1;
        @SerializedName("strFanart2")
        @Expose
        private Object strFanart2;
        @SerializedName("strFanart3")
        @Expose
        private Object strFanart3;
        @SerializedName("strFanart4")
        @Expose
        private Object strFanart4;
        @SerializedName("strLocked")
        @Expose
        private String strLocked;

        public String getIdPlayer() {
            return idPlayer;
        }

        public void setIdPlayer(String idPlayer) {
            this.idPlayer = idPlayer;
        }

        public String getIdTeam() {
            return idTeam;
        }

        public void setIdTeam(String idTeam) {
            this.idTeam = idTeam;
        }

        public String getIdSoccerXML() {
            return idSoccerXML;
        }

        public void setIdSoccerXML(String idSoccerXML) {
            this.idSoccerXML = idSoccerXML;
        }

        public Object getIdPlayerManager() {
            return idPlayerManager;
        }

        public void setIdPlayerManager(Object idPlayerManager) {
            this.idPlayerManager = idPlayerManager;
        }

        public String getStrNationality() {
            return strNationality;
        }

        public void setStrNationality(String strNationality) {
            this.strNationality = strNationality;
        }

        public String getStrPlayer() {
            return strPlayer;
        }

        public void setStrPlayer(String strPlayer) {
            this.strPlayer = strPlayer;
        }

        public String getStrTeam() {
            return strTeam;
        }

        public void setStrTeam(String strTeam) {
            this.strTeam = strTeam;
        }

        public String getStrSport() {
            return strSport;
        }

        public void setStrSport(String strSport) {
            this.strSport = strSport;
        }

        public String getIntSoccerXMLTeamID() {
            return intSoccerXMLTeamID;
        }

        public void setIntSoccerXMLTeamID(String intSoccerXMLTeamID) {
            this.intSoccerXMLTeamID = intSoccerXMLTeamID;
        }

        public String getDateBorn() {
            return dateBorn;
        }

        public void setDateBorn(String dateBorn) {
            this.dateBorn = dateBorn;
        }

        public String getDateSigned() {
            return dateSigned;
        }

        public void setDateSigned(String dateSigned) {
            this.dateSigned = dateSigned;
        }

        public String getStrSigning() {
            return strSigning;
        }

        public void setStrSigning(String strSigning) {
            this.strSigning = strSigning;
        }

        public String getStrWage() {
            return strWage;
        }

        public void setStrWage(String strWage) {
            this.strWage = strWage;
        }

        public String getStrBirthLocation() {
            return strBirthLocation;
        }

        public void setStrBirthLocation(String strBirthLocation) {
            this.strBirthLocation = strBirthLocation;
        }

        public String getStrDescriptionEN() {
            return strDescriptionEN;
        }

        public void setStrDescriptionEN(String strDescriptionEN) {
            this.strDescriptionEN = strDescriptionEN;
        }

        public Object getStrDescriptionDE() {
            return strDescriptionDE;
        }

        public void setStrDescriptionDE(Object strDescriptionDE) {
            this.strDescriptionDE = strDescriptionDE;
        }

        public Object getStrDescriptionFR() {
            return strDescriptionFR;
        }

        public void setStrDescriptionFR(Object strDescriptionFR) {
            this.strDescriptionFR = strDescriptionFR;
        }

        public Object getStrDescriptionCN() {
            return strDescriptionCN;
        }

        public void setStrDescriptionCN(Object strDescriptionCN) {
            this.strDescriptionCN = strDescriptionCN;
        }

        public Object getStrDescriptionIT() {
            return strDescriptionIT;
        }

        public void setStrDescriptionIT(Object strDescriptionIT) {
            this.strDescriptionIT = strDescriptionIT;
        }

        public Object getStrDescriptionJP() {
            return strDescriptionJP;
        }

        public void setStrDescriptionJP(Object strDescriptionJP) {
            this.strDescriptionJP = strDescriptionJP;
        }

        public Object getStrDescriptionRU() {
            return strDescriptionRU;
        }

        public void setStrDescriptionRU(Object strDescriptionRU) {
            this.strDescriptionRU = strDescriptionRU;
        }

        public Object getStrDescriptionES() {
            return strDescriptionES;
        }

        public void setStrDescriptionES(Object strDescriptionES) {
            this.strDescriptionES = strDescriptionES;
        }

        public Object getStrDescriptionPT() {
            return strDescriptionPT;
        }

        public void setStrDescriptionPT(Object strDescriptionPT) {
            this.strDescriptionPT = strDescriptionPT;
        }

        public Object getStrDescriptionSE() {
            return strDescriptionSE;
        }

        public void setStrDescriptionSE(Object strDescriptionSE) {
            this.strDescriptionSE = strDescriptionSE;
        }

        public Object getStrDescriptionNL() {
            return strDescriptionNL;
        }

        public void setStrDescriptionNL(Object strDescriptionNL) {
            this.strDescriptionNL = strDescriptionNL;
        }

        public Object getStrDescriptionHU() {
            return strDescriptionHU;
        }

        public void setStrDescriptionHU(Object strDescriptionHU) {
            this.strDescriptionHU = strDescriptionHU;
        }

        public Object getStrDescriptionNO() {
            return strDescriptionNO;
        }

        public void setStrDescriptionNO(Object strDescriptionNO) {
            this.strDescriptionNO = strDescriptionNO;
        }

        public Object getStrDescriptionIL() {
            return strDescriptionIL;
        }

        public void setStrDescriptionIL(Object strDescriptionIL) {
            this.strDescriptionIL = strDescriptionIL;
        }

        public Object getStrDescriptionPL() {
            return strDescriptionPL;
        }

        public void setStrDescriptionPL(Object strDescriptionPL) {
            this.strDescriptionPL = strDescriptionPL;
        }

        public String getStrGender() {
            return strGender;
        }

        public void setStrGender(String strGender) {
            this.strGender = strGender;
        }

        public String getStrPosition() {
            return strPosition;
        }

        public void setStrPosition(String strPosition) {
            this.strPosition = strPosition;
        }

        public Object getStrCollege() {
            return strCollege;
        }

        public void setStrCollege(Object strCollege) {
            this.strCollege = strCollege;
        }

        public String getStrFacebook() {
            return strFacebook;
        }

        public void setStrFacebook(String strFacebook) {
            this.strFacebook = strFacebook;
        }

        public String getStrWebsite() {
            return strWebsite;
        }

        public void setStrWebsite(String strWebsite) {
            this.strWebsite = strWebsite;
        }

        public String getStrTwitter() {
            return strTwitter;
        }

        public void setStrTwitter(String strTwitter) {
            this.strTwitter = strTwitter;
        }

        public String getStrInstagram() {
            return strInstagram;
        }

        public void setStrInstagram(String strInstagram) {
            this.strInstagram = strInstagram;
        }

        public String getStrYoutube() {
            return strYoutube;
        }

        public void setStrYoutube(String strYoutube) {
            this.strYoutube = strYoutube;
        }

        public String getStrHeight() {
            return strHeight;
        }

        public void setStrHeight(String strHeight) {
            this.strHeight = strHeight;
        }

        public String getStrWeight() {
            return strWeight;
        }

        public void setStrWeight(String strWeight) {
            this.strWeight = strWeight;
        }

        public String getIntLoved() {
            return intLoved;
        }

        public void setIntLoved(String intLoved) {
            this.intLoved = intLoved;
        }

        public String getStrThumb() {
            return strThumb;
        }

        public void setStrThumb(String strThumb) {
            this.strThumb = strThumb;
        }

        public String getStrCutout() {
            return strCutout;
        }

        public void setStrCutout(String strCutout) {
            this.strCutout = strCutout;
        }

        public String getStrFanart1() {
            return strFanart1;
        }

        public void setStrFanart1(String strFanart1) {
            this.strFanart1 = strFanart1;
        }

        public Object getStrFanart2() {
            return strFanart2;
        }

        public void setStrFanart2(Object strFanart2) {
            this.strFanart2 = strFanart2;
        }

        public Object getStrFanart3() {
            return strFanart3;
        }

        public void setStrFanart3(Object strFanart3) {
            this.strFanart3 = strFanart3;
        }

        public Object getStrFanart4() {
            return strFanart4;
        }

        public void setStrFanart4(Object strFanart4) {
            this.strFanart4 = strFanart4;
        }

        public String getStrLocked() {
            return strLocked;
        }

        public void setStrLocked(String strLocked) {
            this.strLocked = strLocked;
        }

    }
}

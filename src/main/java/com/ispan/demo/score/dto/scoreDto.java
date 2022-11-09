package com.ispan.demo.score.dto;

public class scoreDto {
    String gameId;
    String homeTeam;
    String homeR;
    String homeH;
    String homeE;
    String homeRecord;

    String awayTeam;
    String awayR;
    String awayH;
    String awayE;
    String awayRecord;


    public String getHomeTeam() {
        return this.homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeR() {
        return this.homeR;
    }

    public void setHomeR(String homeR) {
        this.homeR = homeR;
    }

    public String getHomeH() {
        return this.homeH;
    }

    public void setHomeH(String homeH) {
        this.homeH = homeH;
    }

    public String getHomeE() {
        return this.homeE;
    }

    public void setHomeE(String homeE) {
        this.homeE = homeE;
    }

    public String getHomeRecord() {
        return this.homeRecord;
    }

    public void setHomeRecord(String homeRecord) {
        this.homeRecord = homeRecord;
    }

    public String getAwayTeam() {
        return this.awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getAwayR() {
        return this.awayR;
    }

    public void setAwayR(String awayR) {
        this.awayR = awayR;
    }

    public String getAwayH() {
        return this.awayH;
    }

    public void setAwayH(String awayH) {
        this.awayH = awayH;
    }

    public String getAwayE() {
        return this.awayE;
    }

    public void setAwayE(String awayE) {
        this.awayE = awayE;
    }

    public String getAwayRecord() {
        return this.awayRecord;
    }

    public void setAwayRecord(String awayRecord) {
        this.awayRecord = awayRecord;
    }

    @Override
    public String toString() {
        return "scoreDto\r\n"+gameId+" \r\nhomeTeam=" + homeTeam + ", homeR=" + homeR + ", homeH=" + homeH + ", homeE=" + homeE
                + ", homeRecord=" + homeRecord + ",\r\nawayTeam=" + awayTeam + ", awayR=" + awayR + ", awayH=" + awayH
                + ", awayE=" + awayE + ", awayRecord=" + awayRecord + "";
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

}
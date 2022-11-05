package com.ispan.demo.team.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NBAPlayer")
public class NBAPlayer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "playerId")
	private Integer playerId;

	private String playerName;

	private String pos;

	private Integer age;

	private String team;

	private Integer game;

	private Integer gameStarted;

	private Float mp;

	private Float fg;

	private Float fga;

	private Float fgperc;

	private Float threefg;

	private Float threefga;

	private Float threefgperc;

	private Float twofg;

	private Float twofga;

	private Float twofgperc;

	private Float efg;

	private Float ft;

	private Float fta;

	private Float ftperc;

	private Float orb;

	private Float drb;

	private Float trb;

	private Float ast;

	private Float stl;

	private Float blk;

	private Float tov;

	private Float pf;

	private Float pts;

	public NBAPlayer() {
		super();
	}
	
	public Integer getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getGame() {
		return game;
	}

	public void setGame(Integer game) {
		this.game = game;
	}

	public Integer getGameStarted() {
		return gameStarted;
	}

	public void setGameStarted(Integer gameStarted) {
		this.gameStarted = gameStarted;
	}

	public Float getMp() {
		return mp;
	}

	public void setMp(Float mp) {
		this.mp = mp;
	}

	public Float getFg() {
		return fg;
	}

	public void setFg(Float fg) {
		this.fg = fg;
	}

	public Float getFga() {
		return fga;
	}

	public void setFga(Float fga) {
		this.fga = fga;
	}

	public Float getFgperc() {
		return fgperc;
	}

	public void setFgperc(Float fgperc) {
		this.fgperc = fgperc;
	}

	public Float getThreefg() {
		return threefg;
	}

	public void setThreefg(Float threefg) {
		this.threefg = threefg;
	}

	public Float getThreefga() {
		return threefga;
	}

	public void setThreefga(Float threefga) {
		this.threefga = threefga;
	}

	public Float getThreefgperc() {
		return threefgperc;
	}

	public void setThreefgperc(Float threefgperc) {
		this.threefgperc = threefgperc;
	}

	public Float getTwofg() {
		return twofg;
	}

	public void setTwofg(Float twofg) {
		this.twofg = twofg;
	}

	public Float getTwofga() {
		return twofga;
	}

	public void setTwofga(Float twofga) {
		this.twofga = twofga;
	}

	public Float getTwofgperc() {
		return twofgperc;
	}

	public void setTwofgperc(Float twofgperc) {
		this.twofgperc = twofgperc;
	}

	public Float getEfg() {
		return efg;
	}

	public void setEfg(Float efg) {
		this.efg = efg;
	}

	public Float getFt() {
		return ft;
	}

	public void setFt(Float ft) {
		this.ft = ft;
	}

	public Float getFta() {
		return fta;
	}

	public void setFta(Float fta) {
		this.fta = fta;
	}

	public Float getFtperc() {
		return ftperc;
	}

	public void setFtperc(Float ftperc) {
		this.ftperc = ftperc;
	}

	public Float getOrb() {
		return orb;
	}

	public void setOrb(Float orb) {
		this.orb = orb;
	}

	public Float getDrb() {
		return drb;
	}

	public void setDrb(Float drb) {
		this.drb = drb;
	}

	public Float getTrb() {
		return trb;
	}

	public void setTrb(Float trb) {
		this.trb = trb;
	}

	public Float getAst() {
		return ast;
	}

	public void setAst(Float ast) {
		this.ast = ast;
	}

	public Float getStl() {
		return stl;
	}

	public void setStl(Float stl) {
		this.stl = stl;
	}

	public Float getBlk() {
		return blk;
	}

	public void setBlk(Float blk) {
		this.blk = blk;
	}

	public Float getTov() {
		return tov;
	}

	public void setTov(Float tov) {
		this.tov = tov;
	}

	public Float getPf() {
		return pf;
	}

	public void setPf(Float pf) {
		this.pf = pf;
	}

	public Float getPts() {
		return pts;
	}

	public void setPts(Float pts) {
		this.pts = pts;
	}

}

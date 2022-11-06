package com.ispan.demo.team.service;

import java.util.List;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.team.model.NBAPlayer;
import com.ispan.demo.team.model.NBAPlayerDao;

@Transactional
@Service
public class NBAPlayerServiceImpl implements NBAPlayerService {
	@Autowired
	private NBAPlayerDao pDao;

	@Override
	public void getStat() {
		pDao.deleteAll();
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.basketball-reference.com/leagues/NBA_2023_per_game.html");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> all = driver.findElements(By.cssSelector(".full_table td"));
		for (int i = 0; i < all.size(); i++) {
			if (i % 29 == 0) {
				NBAPlayer player = new NBAPlayer();
				player.setPlayerName(all.get(i).getText());
				for (int y = 1; y < 29; y++) {
					if (y == 1) {
						player.setPos(all.get(i + y).getText());
					}
					if (y == 2) {
						player.setAge(Integer.parseInt(all.get(i + y).getText()));
					}
					if (y == 3) {
						player.setTeam(all.get(i + y).getText());
					}
					if (y == 4) {
						player.setGame(Integer.parseInt(all.get(i + y).getText()));
					}
					if (y == 5) {
						player.setGameStarted(Integer.parseInt(all.get(i + y).getText()));
					}
					if (y == 6) {
						if (all.get(i + y).getText().equals("")) {
							player.setMp(0.0f);
						} else {
							player.setMp(Float.parseFloat(all.get(i + y).getText()));
						}
					}
					if (y == 7) {
						if (all.get(i + y).getText().equals("")) {
							player.setFg(0.0f);
						} else {
							player.setFg(Float.parseFloat(all.get(i + y).getText()));
						}
					}
					if (y == 8) {
						if (all.get(i + y).getText().equals("")) {
							player.setFga(0.0f);
						} else {
							player.setFga(Float.parseFloat(all.get(i + y).getText()));
						}
					}
					if (y == 9) {
						if (all.get(i + y).getText().equals("")) {
							player.setFgperc(0.0f);
						} else {
							player.setFgperc(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 10) {
						if (all.get(i + y).getText().equals("")) {
							player.setThreefg(0.0f);
						} else {
							player.setThreefg(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 11) {
						if (all.get(i + y).getText().equals("")) {
							player.setThreefga(0.0f);
						} else {
							player.setThreefga(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 12) {
						if (all.get(i + y).getText().equals("")) {
							player.setThreefgperc(0.0f);
						} else {
							player.setThreefgperc(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 13) {
						if (all.get(i + y).getText().equals("")) {
							player.setTwofg(0.0f);
						} else {
							player.setTwofg(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 14) {
						if (all.get(i + y).getText().equals("")) {
							player.setTwofga(0.0f);
						} else {
							player.setTwofga(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 15) {
						if (all.get(i + y).getText().equals("")) {
							player.setTwofgperc(0.0f);
						} else {
							player.setTwofgperc(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 16) {
						if (all.get(i + y).getText().equals("")) {
							player.setEfg(0.0f);
						} else {
							player.setEfg(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 17) {
						if (all.get(i + y).getText().equals("")) {
							player.setFt(0.0f);
						} else {
							player.setFt(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 18) {
						if (all.get(i + y).getText().equals("")) {
							player.setFta(0.0f);
						} else {
							player.setFta(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 19) {
						if (all.get(i + y).getText().equals("")) {
							player.setFtperc(0.0f);
						} else {
							player.setFtperc(Float.parseFloat(all.get(i + y).getText()));
						}

					}
					if (y == 20) {
						
							player.setOrb(Float.parseFloat(all.get(i + y).getText()));
						

					}
					if (y == 21) {
						
							player.setDrb(Float.parseFloat(all.get(i + y).getText()));
						

					}
					if (y == 22) {
						
							player.setTrb(Float.parseFloat(all.get(i + y).getText()));
						

					}
					if (y == 23) {
						
							player.setAst(Float.parseFloat(all.get(i + y).getText()));
						

					}
					if (y == 24) {
						
							player.setStl(Float.parseFloat(all.get(i + y).getText()));
						

					}
					if (y == 25) {
						player.setBlk(Float.parseFloat(all.get(i + y).getText()));
					}
					if (y == 26) {
						player.setTov(Float.parseFloat(all.get(i + y).getText()));
					}
					if (y == 27) {
						player.setPf(Float.parseFloat(all.get(i + y).getText()));
					}
					if (y == 28) {
						player.setPts(Float.parseFloat(all.get(i + y).getText()));
					}
					pDao.save(player);
				}
			}
		}

		driver.close();

	}

	@Override
	public List<NBAPlayer> findAll() {
		return pDao.findAll();
	}

	@Override
	public List<NBAPlayer> findByTeamName(String name) {
		
		return pDao.findByTeam(name);
	}

}

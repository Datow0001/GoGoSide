package com.ispan.demo.team.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.team.model.Team;
import com.ispan.demo.team.model.TeamDao;

@Transactional
@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDao tDao;

	@Override
	public void getTeam() {
		if (tDao.findAll().isEmpty()) {
			System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.mlb.com/standings");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int z = 1; z <= 2; z++) {

				for (int x = 1; x <= 3; x++) {

					for (int i = 1; i <= 5; i++) {
						Team team = new Team();
						WebElement t = driver
								.findElement(By.xpath("/html/body/main/div[2]/div/div/div/section/section/div[" + z
										+ "]/div[" + x + "]/div/div/div[1]/div/table/tbody/tr[" + i
										+ "]/td[1]/span/span/span[1]/span[2]/a"));

//					System.out.println(t.getText());
						team.setName(t.getText());
						if (z == 1 && x == 1) {
							team.setPlace("AL East");
						}
						if (z == 1 && x == 2) {
							team.setPlace("AL Central");
						}
						if (z == 1 && x == 3) {
							team.setPlace("AL West");
						}
						if (z == 2 && x == 1) {
							team.setPlace("NL East");
						}
						if (z == 2 && x == 2) {
							team.setPlace("NL Central");
						}
						if (z == 2 && x == 3) {
							team.setPlace("NL West");
						}

						for (int y = 2; y <= 6; y++) {
							WebElement w = driver.findElement(
									By.xpath("/html/body/main/div[2]/div/div/div/section/section/div[" + z + "]/div["
											+ x + "]/div/div/div[1]/div/table/tbody/tr[" + i + "]/td[" + y + "]/span"));
							if (y == 2) {
								team.setWin(Integer.parseInt(w.getText()));
							}
							if (y == 3) {
								team.setLose(Integer.parseInt(w.getText()));
							}
							if (y == 4) {
								team.setPercent(Float.parseFloat(w.getText()));
							}
							if (y == 5) {
								String diff = w.getText();
								if (diff.equals("-")) {
									diff = "0";
								}
								team.setDiff(Float.parseFloat(diff));
							}
							if (y == 6) {
								String behind = w.getText();

								team.setWcb(behind);
							}
						}
						tDao.save(team);

					}
				}
			}

			driver.close();
		}
	}

	public void update() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mlb.com/standings");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int z = 1; z <= 2; z++) {

			for (int x = 1; x <= 3; x++) {

				for (int i = 1; i <= 5; i++) {
					Team team = new Team();
					WebElement t = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/section/section/div["
							+ z + "]/div[" + x + "]/div/div/div[1]/div/table/tbody/tr[" + i
							+ "]/td[1]/span/span/span[1]/span[2]/a"));

//					System.out.println(t.getText());
					team.setName(t.getText());
					if (z == 1 && x == 1) {
						team.setPlace("AL East");
					}
					if (z == 1 && x == 2) {
						team.setPlace("AL Central");
					}
					if (z == 1 && x == 3) {
						team.setPlace("AL West");
					}
					if (z == 2 && x == 1) {
						team.setPlace("NL East");
					}
					if (z == 2 && x == 2) {
						team.setPlace("NL Central");
					}
					if (z == 2 && x == 3) {
						team.setPlace("NL West");
					}

					for (int y = 2; y <= 6; y++) {
						WebElement w = driver.findElement(
								By.xpath("/html/body/main/div[2]/div/div/div/section/section/div[" + z + "]/div[" + x
										+ "]/div/div/div[1]/div/table/tbody/tr[" + i + "]/td[" + y + "]/span"));
						if (y == 2) {
							team.setWin(Integer.parseInt(w.getText()));
						}
						if (y == 3) {
							team.setLose(Integer.parseInt(w.getText()));
						}
						if (y == 4) {
							team.setPercent(Float.parseFloat(w.getText()));
						}
						if (y == 5) {
							String diff = w.getText();
							if (diff.equals("-")) {
								diff = "0";
							}
							team.setDiff(Float.parseFloat(diff));
						}
						if (y == 6) {
							String behind = w.getText();

							team.setWcb(behind);
						}
					}

					List<Team> teamsInTable = tDao.findAll();

					for (Team team2 : teamsInTable) {
						if (team2.getName().equals(team.getName())) {
							team2.setWin(team.getWin());
							team2.setLose(team.getLose());
							team2.setPercent(team.getPercent());
							team2.setWcb(team.getWcb());
							team2.setDiff(team.getDiff());
							tDao.save(team2);

						}
					}

				}
			}
		}

		driver.close();
	}

	@Override
	public List<Team> findTeams(String place) {
		return tDao.findByPlaceOrderByPercentDesc(place);

	}

	@Override
	public List<Team> finAll() {
		return tDao.findAll();
	}

	@Override
	public Team insert(Team t) {
		return tDao.save(t);
	}

	@Override
	public Team findById(Integer id) {

		Optional<Team> team = tDao.findById(id);

		if (team.isPresent()) {
			return team.get();
		}
		return null;
	}
}

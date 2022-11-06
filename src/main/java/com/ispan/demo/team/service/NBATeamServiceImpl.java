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

import com.ispan.demo.team.model.NBATeam;
import com.ispan.demo.team.model.NBATeamDao;

@Transactional
@Service
public class NBATeamServiceImpl implements NBATeamService {
	@Autowired
	private NBATeamDao nDao;

	@Override
	public void getStanding() {
		if(nDao.findAll().isEmpty()) {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cbssports.com/nba/standings/regular/conference/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> logo = driver.findElements(By.className("TeamLogo-image"));
		logo.remove(0);
		logo.remove(15);
		int logocount = 0;

		List<WebElement> stat = driver.findElements(By.className("TableBase-bodyTd"));
		for (int i = 0; i < stat.size(); i++) {
			if (i % 18 == 1) {
				NBATeam team = new NBATeam();
				team.setTeamImageSrc(logo.get(logocount).getAttribute("data-lazy"));
				logocount++;
				if (logocount <= 15) {
					team.setTeamDiv("EAST");
				} else {
					team.setTeamDiv("WEST");
				}
//				-----------------
//				URL url;
//				try {
//					url = new URL(logo.get(logocount).getAttribute("data-lazy"));
//					URLConnection con = url.openConnection();
//					con.setConnectTimeout(5 * 1000);
//					InputStream is = con.getInputStream();
//					byte[] x=is.readAllBytes();
//					team.setTeamImage(x);
//					if(logocount<=14) {
//						team.setTeamDiv("EAST");
//					}else {team.setTeamDiv("WEST");}
//					logocount++;
//					is.close();
//				} catch (MalformedURLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

//				-----------------
				for (int y = 0; y <= 13; y++) {
					if (y == 0) {
						team.setTeamName(stat.get(i + y).getText());
					}
					if (y == 1) {
						team.setWin(Integer.parseInt(stat.get(i + y).getText()));
					}
					if (y == 2) {
						team.setLose(Integer.parseInt(stat.get(i + y).getText()));
					}
					if (y == 3) {
						team.setPercent(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 4) {
						if (stat.get(i + y).getText().equals("—")) {
							Float gb;
							gb = 0f;
							team.setGb(gb);
						} else {
							team.setGb(Float.parseFloat(stat.get(i + y).getText()));
						}
					}
					if (y == 5) {
						team.setPpg(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 6) {
						team.setOppg(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 7) {
						team.setDiff(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 10) {
						team.setHome(stat.get(i + y).getText());
					}
					if (y == 11) {
						team.setRoad(stat.get(i + y).getText());
					}
					if (y == 12) {
						team.setStrk(stat.get(i + y).getText());
					}
					if (y == 13) {
						team.setLastTen(stat.get(i + y).getText());
					}
				}

				nDao.save(team);
			}

		}
		driver.close();
		}
	}
	
	@Override
	public void updateStanding() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cbssports.com/nba/standings/regular/conference/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> logo = driver.findElements(By.className("TeamLogo-image"));
		logo.remove(0);
		logo.remove(15);
		int logocount = 0;

		List<WebElement> stat = driver.findElements(By.className("TableBase-bodyTd"));
		for (int i = 0; i < stat.size(); i++) {
			if (i % 18 == 1) {
				NBATeam team = new NBATeam();
				team.setTeamImageSrc(logo.get(logocount).getAttribute("data-lazy"));
				logocount++;
				if (logocount <= 15) {
					team.setTeamDiv("EAST");
				} else {
					team.setTeamDiv("WEST");
				}

				for (int y = 0; y <= 13; y++) {
					if (y == 0) {
						team.setTeamName(stat.get(i + y).getText());
					}
					if (y == 1) {
						team.setWin(Integer.parseInt(stat.get(i + y).getText()));
					}
					if (y == 2) {
						team.setLose(Integer.parseInt(stat.get(i + y).getText()));
					}
					if (y == 3) {
						team.setPercent(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 4) {
						if (stat.get(i + y).getText().equals("—")) {
							Float gb;
							gb = 0f;
							team.setGb(gb);
						} else {
							team.setGb(Float.parseFloat(stat.get(i + y).getText()));
						}
					}
					if (y == 5) {
						team.setPpg(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 6) {
						team.setOppg(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 7) {
						team.setDiff(Float.parseFloat(stat.get(i + y).getText()));
					}
					if (y == 10) {
						team.setHome(stat.get(i + y).getText());
					}
					if (y == 11) {
						team.setRoad(stat.get(i + y).getText());
					}
					if (y == 12) {
						team.setStrk(stat.get(i + y).getText());
					}
					if (y == 13) {
						team.setLastTen(stat.get(i + y).getText());
					}
				}
				List<NBATeam> teamsInTable = nDao.findAll();
				for (NBATeam nbaTeam : teamsInTable) {
					if(nbaTeam.getTeamName().equals(team.getTeamName())) {
						nbaTeam.setWin(team.getWin());
						nbaTeam.setLose(team.getLose());
						nbaTeam.setPercent(team.getPercent());
						nbaTeam.setGb(team.getGb());
						nbaTeam.setPpg(team.getPpg());
						nbaTeam.setOppg(team.getOppg());
						nbaTeam.setDiff(team.getDiff());
						nbaTeam.setHome(team.getHome());
						nbaTeam.setRoad(team.getRoad());
						nbaTeam.setStrk(team.getStrk());
						nbaTeam.setLastTen(team.getLastTen());
					}
					nDao.save(nbaTeam);
				}
			}

		}
		driver.close();

	}

	@Override
	public List<NBATeam> findByDiv(String string) {
		return nDao.findByTeamDiv(string);

	}

	@Override
	public NBATeam findById(Integer id) {
		Optional<NBATeam> team = nDao.findById(id);
		if (team.isPresent()) {
			return team.get();
		}
		return null;

	}

	@Override
	public NBATeam findByName(String name) {		
		return nDao.findByTeamName(name);
	}

}

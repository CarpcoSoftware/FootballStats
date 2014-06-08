/**
 * 
 */
package co.com.carpco.footballstats.test.insert;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.joda.time.DateTime;

import co.com.carpco.footballstats.bo.CountryBO;
import co.com.carpco.footballstats.bo.TeamBO;
import co.com.carpco.footballstats.bo.TournamentBO;
import co.com.carpco.footballstats.bo.TournamentTypeBO;
import co.com.carpco.footballstats.entity.Country;
import co.com.carpco.footballstats.entity.Team;
import co.com.carpco.footballstats.entity.Tournament;
import co.com.carpco.footballstats.entity.TournamentType;
import co.com.carpco.footballstats.spring.ServiceLocator;

/**
 * @author Carlos Rodriguez
 */
public class InsertImageTest {

  /**
   * @param args
   */
  public static void main(String[] args) {
    ServiceLocator.init();
    InsertImageTest imageTest = new InsertImageTest();
    //imageTest.insertCountry();
    imageTest.insertTeam();
    //imageTest.insertTournament();
    //imageTest.updateCountry();
  }
  
  private void insertTournament() {
    TournamentBO tournamentBO = ServiceLocator.getBean(TournamentBO.class);
    CountryBO countryBO = ServiceLocator.getBean(CountryBO.class);
    TournamentTypeBO typeBO = ServiceLocator.getBean(TournamentTypeBO.class);

    BufferedImage imBuff = null;
    InputStream is = InsertImageTest.class.getResourceAsStream("/flags/wc_trophy.png");

    try {
      imBuff = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (imBuff != null) {
      Country country = countryBO.findByIdentifier(5);
      TournamentType tournamentType = typeBO.findByIdentifier(1); 
      Tournament tournament = new Tournament("world_cup", 1930, imBuff, country, tournamentType);
      tournamentBO.insertRecord(tournament);
    }
  }

  private void insertCountry() {
    CountryBO countryBO = ServiceLocator.getBean(CountryBO.class);

    BufferedImage imBuff = null;
    InputStream is = InsertImageTest.class.getResourceAsStream("/flags/mexico.png");

    try {
      imBuff = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (imBuff != null) {
      Country country = new Country("mexico", imBuff, "spanish", "");
      countryBO.insertRecord(country);
    }
  }

  private void insertTeam() {
    TeamBO teamBO = ServiceLocator.getBean(TeamBO.class);
    CountryBO countryBO = ServiceLocator.getBean(CountryBO.class);

    BufferedImage imBuff = null;
    InputStream is = InsertImageTest.class.getResourceAsStream("/flags/mexico_fmf.png");

    try {
      imBuff = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (imBuff != null) {
      Country country = (Country) countryBO.findByIdentifier(9);
      Team team = new Team("mexico", "El tri", imBuff, country, 1929, 0, "");
      teamBO.insertRecord(team);
    }
  }

  private void updateCountry() {
    CountryBO countryBO = ServiceLocator.getBean(CountryBO.class);
    
    BufferedImage imBuff = null;
    InputStream is = InsertImageTest.class.getResourceAsStream("/flags/croatia.png");

    try {
      imBuff = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    if (imBuff != null) {
      Country country = countryBO.findByIdentifier(7);
      country.setFlag(imBuff);
      countryBO.updateRecord(country);
    }
  }
}

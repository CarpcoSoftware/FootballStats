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
import co.com.carpco.footballstats.entity.Country;
import co.com.carpco.footballstats.entity.Team;
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
    imageTest.insertCountry();
    imageTest.insertTeam();
  }

  private void insertCountry() {
    CountryBO countryBO = ServiceLocator.getBean(CountryBO.class);

    BufferedImage imBuff = null;
    InputStream is = InsertImageTest.class.getResourceAsStream("/flags/brazil.png");

    try {
      imBuff = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (imBuff != null) {
      Country country = new Country("Brazil", imBuff, "Portuguese");
      countryBO.insertRecord(country);
    }
  }

  private void insertTeam() {
    TeamBO teamBO = ServiceLocator.getBean(TeamBO.class);
    CountryBO countryBO = ServiceLocator.getBean(CountryBO.class);

    BufferedImage imBuff = null;
    InputStream is = InsertImageTest.class.getResourceAsStream("/flags/brazil-cbf.png");

    try {
      imBuff = ImageIO.read(is);
    } catch (IOException e) {
      e.printStackTrace();
    }

    if (imBuff != null) {
      Country country = (Country) countryBO.findByIdentifier(4);
      DateTime foundation = new DateTime(1914, 6, 8, 0, 0);
      Team team = new Team("Brazil", "Verdeamarela", imBuff, country, foundation);
      teamBO.insertRecord(team);
    }
  }

}

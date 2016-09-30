package minister.portal.com.voiceofheart;

/**
 * Created by Pawan on 9/27/2016.
 */

public class NewsBeans {


    public String newsid;
    public String newstitle;
    public String statename;
    public String countryname;


    public NewsBeans() {
    }


    public NewsBeans(String newsid, String newstitle, String statename, String countryname) {
        super();
        this.newsid = newsid;
        this.newstitle = newstitle;
        this.statename = statename;
        this.countryname = countryname;

    }


    public String getNewsid() {
        return newsid;
    }

    public void setNewsid(String newsid) {
        this.newsid = newsid;
    }

    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }
}

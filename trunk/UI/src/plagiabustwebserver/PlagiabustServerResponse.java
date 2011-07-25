/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plagiabustwebserver;

import java.util.Date;

/**
 *
 * @author Brave Heart
 */
public class PlagiabustServerResponse {

    private String Url;
    private String Content;
    private String Title;
    private Date LastModified;
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public Date getLastModified() {
        return LastModified;
    }

    public void setLastModified(Date LastModified) {
        this.LastModified = LastModified;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }
}

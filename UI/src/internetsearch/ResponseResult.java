package internetsearch;

public class ResponseResult
{
    private String Url;
    private String Description;
    private String LastCrawledDate;
    private String Title;
    private String DisplayUrl;

    public String getDisplayUrl()
    {
        return DisplayUrl;
    }

    public void setDisplayUrl(String DisplayUrl)
    {
        this.DisplayUrl = DisplayUrl;
    }

    public String getLastCrawledDate()
    {
        return LastCrawledDate;
    }

    public void setLastCrawledDate(String LastCrawledDate)
    {
        this.LastCrawledDate = LastCrawledDate;
    }

    public String getTitle()
    {
        return Title;
    }

    public void setTitle(String Title)
    {
        this.Title = Title;
    }

    public String getDescription() 
    {
        return Description;
    }

    public void setDescription(String Description)
    {
        this.Description = Description;
    }

    public String getUrl()
    {
        return Url;
    }

    public void setUrl(String Url)
    {
        this.Url = Url;
    }


}

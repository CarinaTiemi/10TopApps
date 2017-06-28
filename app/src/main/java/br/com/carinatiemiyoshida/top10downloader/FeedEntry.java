package br.com.carinatiemiyoshida.top10downloader;

/**
 * Created by CarinaTiemiYoshida on 07/06/2017.
 */

public class FeedEntry {
    private String name;
    private String artist;
    private String releaseDate;
    private String summary;
    private String imageURL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("");
        sb.append("name= ").append(name).append('\n');
        sb.append("artist= ").append(artist).append('\n');
        sb.append("releaseDate= ").append(releaseDate).append('\n');
        sb.append("imageURL= ").append(imageURL).append('\n');
        return sb.toString();
    }
}

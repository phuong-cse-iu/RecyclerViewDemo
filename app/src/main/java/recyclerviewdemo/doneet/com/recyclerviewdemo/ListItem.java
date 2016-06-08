package recyclerviewdemo.doneet.com.recyclerviewdemo;

/**
 * Created by TranTPhuong on 6/8/2016.
 */
public class ListItem {
    private String title;
    private int imageResId;
    private String subTitle;
    private boolean favorite = false;

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}

package cn.dhc.logon.emun;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-08-17
 */
public enum DogType {
    CHINESE_GARDEN_DOG(1, "Chinese garden dog"),
    SHIBA_INU(2, "shiba inu"),
    HUSKY(3, "husky");

    private int i;
    private String description;

    private DogType(int i, String description) {
        this.i = i;
        this.description = description;
    }

    public int getNum() {
        return i;
    }

    public String getDescroption() {
        return description;
    }

}

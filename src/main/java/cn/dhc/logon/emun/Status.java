package cn.dhc.logon.emun;

import lombok.Getter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-21
 */
@Getter
@ToString
public enum Status {
    /**
     * active
     */
    ACTIVE("active"),
    /**
     * in active
     */
    INACTIVE("In active");
    private String desc;

    Status(String desc) {
        this.desc = desc;
    }
}

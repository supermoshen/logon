package cn.dhc.logon.entity;


import lombok.Data;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-02
 */
@Table(name = "USER")
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username", unique = true, nullable = false, length = 64)
    private String username;

    @Column(name = "age",unique = true)
    private Integer age;

    @Column(name = "hobby")
    private String hobby;

    @Column(name = "update_time")
    @LastModifiedDate
    private Date updateTime;

}

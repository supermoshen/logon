package cn.dhc.logon.entity;

import cn.dhc.logon.emun.DogType;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * dog entity
 *
 * @author : charles
 * @date : 2019-08-17
 */
@Data
@ToString
public class Dog {
    private BigDecimal id;
    private String name;
    private String description;
    private DogType dogType;
}


package com.working.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 商品实体
 *
 */
public class Goods implements Serializable {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    /*
     * 编号
     */
    private int id;
    
    /*
     * 名称
     */
    @Pattern(regexp = "^[^><&#]{1,50}$", message = "{pattern}")
    @NotNull(message = "{notNull}")
    private String name;
    
    public Goods() {
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}

package com.xdx.hello.spring.boot.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_category")
public class TCategory {
    /**
     * 主键，类别Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 类别名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 获取主键，类别Id
     *
     * @return id - 主键，类别Id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键，类别Id
     *
     * @param id 主键，类别Id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return is_del
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * @param isDel
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    /**
     * 获取类别名称
     *
     * @return category_name - 类别名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置类别名称
     *
     * @param categoryName 类别名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
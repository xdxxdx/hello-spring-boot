package com.xdx.hello.spring.boot.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "t_commodity")
public class TCommodity {
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
     * 商品类别id
     */
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "commodity_name")
    private String commodityName;

    @Column(name = "commodity_unit")
    private String commodityUnit;

    /**
     * 交货周期，单位为天
     */
    @Column(name = "delivery_cycle")
    private Integer deliveryCycle;

    private String note;

    private TCategory category;

    private List<TSpec> specs;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
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
     * 获取商品类别id
     *
     * @return category_id - 商品类别id
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 设置商品类别id
     *
     * @param categoryId 商品类别id
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return commodity_unit
     */
    public String getCommodityUnit() {
        return commodityUnit;
    }

    /**
     * @param commodityUnit
     */
    public void setCommodityUnit(String commodityUnit) {
        this.commodityUnit = commodityUnit;
    }

    /**
     * 获取交货周期，单位为天
     *
     * @return delivery_cycle - 交货周期，单位为天
     */
    public Integer getDeliveryCycle() {
        return deliveryCycle;
    }

    /**
     * 设置交货周期，单位为天
     *
     * @param deliveryCycle 交货周期，单位为天
     */
    public void setDeliveryCycle(Integer deliveryCycle) {
        this.deliveryCycle = deliveryCycle;
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }

    public TCategory getCategory() {
        return category;
    }

    public void setCategory(TCategory category) {
        this.category = category;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public List<TSpec> getSpecs() {
        return specs;
    }

    public void setSpecs(List<TSpec> specs) {
        this.specs = specs;
    }
}
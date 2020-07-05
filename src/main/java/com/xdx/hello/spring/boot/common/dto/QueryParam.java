package com.xdx.hello.spring.boot.common.dto;

import lombok.Data;

@Data
public class QueryParam {
    private String sort="id";
    private String userName;
    private String sortOrder;
    private String userNo;
    private Long userId;
    private Integer direction; //方向，1表示充值，0表示消费
    private String categoryName;
    private String commodityName;

    public void setSortOrder() {
        if(this.sort.indexOf("-")>-1){
            this.sortOrder = "desc";
        }else{
            this.sortOrder="asc";
        }

    }

    public String getSortOrder(){
        setSortOrder();
        return this.sortOrder;
    }

    public void formatSort(){
        if(this.sort.indexOf("-")>-1){
            this.sortOrder = "desc";
            this.sort=this.sort.substring(1);
        }else{
            this.sortOrder="asc";
        }
    }
}

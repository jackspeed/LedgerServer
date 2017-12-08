package com.ycj.ledger.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author ycj
 * @version V1.0 <消费记录>
 * @date 2017-12-07 17:45
 */
public class ConsumeRecord {

    /**
     * 主键
     */
    private Long id;

    /**
     * 状态 0正常 1删除
     */
    private String status;
    private String userName;
    private String mobile;
    /**
     * 用户id
     */
    @JSONField(name = "user_id")
    private String userId;

    /**
     * 消费时间
     */
    @JSONField(name = "consume_date")
    private String consumeDate;

    /**
     * 消费金额
     */
    @JSONField(name = "consume_money")
    private String consumeMoney;

    /**
     * 修改时间
     */
    @JSONField(name = "update_date", format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    /**
     * 创建时间
     */
    @JSONField(name = "create_date", format = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getConsumeDate() {
        return consumeDate;
    }

    public void setConsumeDate(String consumeDate) {
        this.consumeDate = consumeDate;
    }

    public String getConsumeMoney() {
        return consumeMoney;
    }

    public void setConsumeMoney(String consumeMoney) {
        this.consumeMoney = consumeMoney;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

package org.nix.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.validator.constraints.Length;
import org.nix.common.sysenum.SysOrderEnum;
import org.nix.entity.basic.BasicEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Create by zhangpe0312@qq.com on 2018/4/8.
 * TODO: 物流订单表
 */
@Entity
@Table(name = "SysOrder")
public class SysOrder extends BasicEntity {

    //订单费用
    private double cost;
    //订单状态
    private SysOrderEnum orderStatus;
    //订单备注
    private String node;
    //订单到达当前地点时的时间为
    private Date TimeOfArrival;

    //该订单所属的用户
    private SysUser sysUser;
    //订单目前所在的地点
    private City currentCity;
    //订单开始出发的地点
    private City startCity;
    //订单的目的地
    private City endCity;

    @Column(name = "cost", nullable = false)
    public double getCost() {
        return cost;
    }

    @Column(name = "orderStatus", nullable = false)
    @Enumerated(EnumType.STRING)
    public SysOrderEnum getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单备注最多50个字
     *
     * @return 订单备注
     */
    @Column(name = "node", length = 100)
    @Length(max = 100)
    public String getNode() {
        return node;
    }

    @Column(name = "TimeOfArrival", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimeOfArrival() {
        return TimeOfArrival;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = SysUser.class)
    @JoinColumn(name = "sysUser")
    public SysUser getSysUser() {
        return sysUser;
    }


    @ManyToOne(targetEntity = City.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "currentCity")
    public City getCurrentCity() {
        return currentCity;
    }

    @ManyToOne(targetEntity = City.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "startCity")
    public City getStartCity() {
        return startCity;
    }

    @ManyToOne(targetEntity = City.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "endCity")
    public City getEndCity() {
        return endCity;
    }


    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setOrderStatus(SysOrderEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public void setTimeOfArrival(Date timeOfArrival) {
        TimeOfArrival = timeOfArrival;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }
}

package org.nix.dao.repositories;

import org.nix.entity.SysOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by zhangpe0312@qq.com on 2018/4/8.
 *
 * TODO: 订单底层业务接口
 */
public interface SysOrderJpa extends JpaRepository<SysOrder,Integer> {
}
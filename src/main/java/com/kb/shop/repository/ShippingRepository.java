package com.kb.shop.repository;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.domain.enums.ShippingStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShippingRepository {
    private final JdbcTemplate jdbcTemplate;

    public ShippingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ShippingInfo selectShippingInfo(Long id) {
        String sql = "SELECT * FROM shipping_info WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(ShippingInfo.class));
    }

    public ShippingInfo setShippingInfo(ShippingInfo shippingInfo) {
        String sql = "INSERT INTO shipping_info (order_id, order_item_id, status) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, shippingInfo.getOrderId(), shippingInfo.getOrderItemId(), shippingInfo.getStatus().toString());
        return shippingInfo;
    }

    public void updateShippingStatus(Long shippingInfoId, ShippingStatus newStatus) {
        String sql = "UPDATE shipping_info SET status = ? WHERE id = ?";
        jdbcTemplate.update(sql, newStatus.toString(), shippingInfoId);
    }
}

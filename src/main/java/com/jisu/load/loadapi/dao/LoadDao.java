package com.jisu.load.loadapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jisu.load.loadapi.model.Load;
import java.util.UUID;

public interface LoadDao extends JpaRepository<Load, Integer> {

    List<Load> findByShipperId(UUID shipperId);
}

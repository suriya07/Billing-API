package com.billing.core.repository;

import com.billing.core.entity.PluginMeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PluginRepository extends JpaRepository<PluginMeta, String> {}

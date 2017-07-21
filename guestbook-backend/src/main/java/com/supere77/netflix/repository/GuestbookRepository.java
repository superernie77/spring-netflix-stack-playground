package com.supere77.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supere77.netflix.domain.GuestbookEntry;

public interface GuestbookRepository extends JpaRepository<GuestbookEntry, Long> {}

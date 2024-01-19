package com.tunehub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.entity.PlayList;

public interface PlaylistRepository extends JpaRepository<PlayList, Integer>{

}

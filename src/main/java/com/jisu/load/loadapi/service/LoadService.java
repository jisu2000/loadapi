package com.jisu.load.loadapi.service;

import java.util.List;
import java.util.UUID;

import com.jisu.load.loadapi.playload.LoadDto;

public interface LoadService {

    LoadDto saveLoad(LoadDto dto);

    List<LoadDto> getAllLoad();

    LoadDto getLoadById(Integer loadId);

    LoadDto updateLoad(Integer loadId, LoadDto dto);

    LoadDto deleteLoad(Integer loadId);

    List<LoadDto> getByShipId(UUID id);

}

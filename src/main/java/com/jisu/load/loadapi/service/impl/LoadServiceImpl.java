package com.jisu.load.loadapi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jisu.load.loadapi.dao.LoadDao;
import com.jisu.load.loadapi.exception.LoadNotFoundException;
import com.jisu.load.loadapi.model.Load;
import com.jisu.load.loadapi.playload.LoadDto;
import com.jisu.load.loadapi.service.LoadService;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    private LoadDao loadDao;

    @Autowired
    private ModelMapper mapper;

    @Override
    public LoadDto saveLoad(LoadDto dto) {

        Load load = this.mapper.map(dto, Load.class);
        Load saved = this.loadDao.save(load);

        return this.mapper.map(saved, LoadDto.class);

    }

    @Override
    public List<LoadDto> getAllLoad() {

        List<LoadDto> res = new ArrayList<>();

        for (Load l : this.loadDao.findAll()) {
            res.add(this.mapper.map(l, LoadDto.class));
        }

        return res;
    }

    @Override
    public LoadDto getLoadById(Integer loadId) {

        Load find = this.loadDao.findById(loadId)
                .orElseThrow(() -> new LoadNotFoundException("Load Not found With loadId " + loadId));

        return this.mapper.map(find, LoadDto.class);
    }

    @Override
    public LoadDto updateLoad(Integer loadId, LoadDto dto) {
        Load find = this.loadDao.findById(loadId)
                .orElseThrow(() -> new LoadNotFoundException("Load Not found With loadId " + loadId));

        if (dto.getLoadingPoint() != null && !dto.getLoadingPoint().equals("")) {
            find.setLoadingPoint(dto.getLoadingPoint());
        } else {
            find.setLoadingPoint(find.getLoadingPoint());
        }

        if (dto.getUnloadingPoint() != null && !dto.getUnloadingPoint().equals("")) {
            find.setUnloadingPoint(dto.getUnloadingPoint());
        } else {
            find.setUnloadingPoint(find.getUnloadingPoint());
        }

        if (dto.getProductType() != null && !dto.getProductType().equals("")) {
            find.setProductType(dto.getProductType());
        } else {
            find.setProductType(find.getProductType());
        }
        if (dto.getTruckType() != null && !dto.getTruckType().equals("")) {
            find.setTruckType(dto.getTruckType());
        } else {
            find.setTruckType(find.getTruckType());
        }

        if (dto.getNoOfTrucks() != null && dto.getNoOfTrucks() > 0) {
            find.setNoOfTrucks(dto.getNoOfTrucks());
        } else {
            find.setNoOfTrucks(find.getNoOfTrucks());
        }

        if (dto.getWeight() != null && dto.getWeight() > 0) {
            find.setWeight(dto.getWeight());
        } else {
            find.setWeight(find.getWeight());
        }

        if (dto.getComment() != null && !dto.getComment().equals("")) {
            find.setComment(dto.getComment());
        } else {
            find.setComment(find.getComment());
        }

        if (dto.getDate() != null && !dto.getDate().equals("")) {
            find.setDate(dto.getDate());
        } else {
            find.setDate(find.getDate());
        }

        Load saved = this.loadDao.save(find);

        return this.mapper.map(saved, LoadDto.class);

    }

    @Override
    public LoadDto deleteLoad(Integer loadId) {

        Load find = this.loadDao.findById(loadId)
                .orElseThrow(() -> new LoadNotFoundException("Load Not found With loadId " + loadId));

        this.loadDao.delete(find);

        return this.mapper.map(find, LoadDto.class);
    }

    @Override
    public List<LoadDto> getByShipId(UUID id) {
        List<LoadDto> res = new ArrayList<>();
        for (Load l : this.loadDao.findByShipperId(id)) {
            res.add(this.mapper.map(l, LoadDto.class));
        }
        return res;
    }

}

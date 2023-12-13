package com.jisu.load.loadapi.playload;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoadDto {
    private Integer loadId;
    private UUID shipperId;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private Integer noOfTrucks;
    private String truckType;
    private Integer weight;
    private String comment;
    private Date date;
}

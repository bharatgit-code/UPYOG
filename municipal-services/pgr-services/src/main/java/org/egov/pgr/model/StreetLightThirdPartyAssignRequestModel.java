package org.egov.pgr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StreetLightThirdPartyAssignRequestModel {

    private Integer externalId;
    private String wardName;
    private String rootName;
    private String complaintType;
    private String info;
    private Integer latitude;
    private Integer longitude;
    private String image;
    private Boolean isReopen;
    private String remarks;
    private Integer cityId;
    private String poleNo;
    private String phone;
}

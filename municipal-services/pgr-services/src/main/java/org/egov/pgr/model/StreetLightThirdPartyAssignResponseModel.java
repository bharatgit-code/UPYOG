package org.egov.pgr.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StreetLightThirdPartyAssignResponseModel {

    private Integer result;
    private Integer count;
    private int id;
    private boolean status;
    private int statusCode;
    private String message;
}

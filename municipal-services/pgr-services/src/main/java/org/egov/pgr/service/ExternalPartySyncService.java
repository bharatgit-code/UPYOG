package org.egov.pgr.service;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.egov.pgr.model.StreetLightThirdPartyAssignRequestModel;
import org.egov.pgr.model.StreetLightThirdPartyAssignResponseModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalPartySyncService {
    private static final Logger LOG = LogManager.getLogger(ExternalPartySyncService.class);

    @Value("${streetlight.external.api.url}")
    private String streetLightExternalAPIUrl;

    @Value("${streetlight.external.api.bearer.token}")
    private String getStreetLightExternalAPIBearerToken;

    private final RestTemplate restTemplate;

    @Autowired
    public ExternalPartySyncService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public StreetLightThirdPartyAssignResponseModel assignToThirdParty() {
        LOG.info("Process Start: Assign streetlight request to third party");
        StopWatch watcher = StopWatch.createStarted();
        StreetLightThirdPartyAssignRequestModel requestBody = getStreetLightThirdPartyAssignRequestModel();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Set content type if sending JSON
        headers.setBearerAuth(getStreetLightExternalAPIBearerToken); // Set the bearer token (Spring 5.1+ method)

        HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<StreetLightThirdPartyAssignResponseModel> response = restTemplate.exchange(
                streetLightExternalAPIUrl,
                HttpMethod.POST,
                requestEntity,
                StreetLightThirdPartyAssignResponseModel.class
        );
        watcher.stop();
        LOG.info("Process End: Assign streetlight request to third party, execution time in MS: {}", watcher.getTime());
        return response.getBody();
    }

    @NotNull
    private static StreetLightThirdPartyAssignRequestModel getStreetLightThirdPartyAssignRequestModel() {
        StreetLightThirdPartyAssignRequestModel requestBody = new StreetLightThirdPartyAssignRequestModel();
        requestBody.setExternalId(0);
        requestBody.setInfo("Test");
        requestBody.setWardName("Prabhag No. 18");
        requestBody.setRootName("Nasik Road");
        requestBody.setComplaintType("1");
        requestBody.setImage("");
        requestBody.setRemarks("Led not working");
        requestBody.setCityId(2);
        requestBody.setPoleNo("Near Temple");
        requestBody.setPhone("9999999999");
        return requestBody;
    }

}

/*
 * CPOO Server API
 * This is a prototype of CPOO Project's front/back API. 
 *
 * The version of the OpenAPI document: 0.0.1
 * Contact: contact@mightycode.fr
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiException;
import org.openapitools.client.model.ChangePasswordDTO;
import org.openapitools.client.model.ErrorDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ChangePwdApi
 */
@Disabled
public class ChangePwdApiTest {

    private final ChangePwdApi api = new ChangePwdApi();

    /**
     * @throws ApiException if the Api call fails
     */
    @Test
    public void userChangepwdPatchTest() throws ApiException {
        ChangePasswordDTO changePasswordDTO = null;
        api.userChangepwdPatch(changePasswordDTO);
        // TODO: test validations
    }

}

/*
 * CPOO Server API
 * This is a prototype of CPOO Project's front/back API. 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: contact@mightycode.fr
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.client.api;

import io.swagger.client.model.ErrorDTO;
import io.swagger.client.model.NewPasswordDTO;
import org.junit.Test;
import org.junit.Ignore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * API tests for ForgotPwdApi
 */
@Ignore
public class ForgotPwdApiTest {

    private final ForgotPwdApi api = new ForgotPwdApi();

    /**
     * 
     *
     * 
     *
     * @throws Exception
     *          if the Api call fails
     */
    @Test
    public void userForgotpwdPostTest() throws Exception {
        NewPasswordDTO body = null;
        api.userForgotpwdPost(body);

        // TODO: test validations
    }
}

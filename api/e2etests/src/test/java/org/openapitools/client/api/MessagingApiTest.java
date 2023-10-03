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
import org.openapitools.client.model.DiscussionDTO;
import org.openapitools.client.model.DiscussionsCreatePostRequest;
import org.openapitools.client.model.ErrorDTO;
import org.openapitools.client.model.MessageDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MessagingApi
 */
@Disabled
public class MessagingApiTest {

    private final MessagingApi api = new MessagingApi();

    /**
     * Create a new discussion
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void discussionsCreatePostTest() throws ApiException {
        DiscussionsCreatePostRequest discussionsCreatePostRequest = null;
        api.discussionsCreatePost(discussionsCreatePostRequest);
        // TODO: test validations
    }

    /**
     * Get all messages in a conversation
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void discussionsDiscussionIdMessagesGetTest() throws ApiException {
        Integer discussionId = null;
        List<MessageDTO> response = api.discussionsDiscussionIdMessagesGet(discussionId);
        // TODO: test validations
    }

    /**
     * Send a message in a disccusion
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void discussionsDiscussionIdMessagesPostTest() throws ApiException {
        Integer discussionId = null;
        MessageDTO messageDTO = null;
        api.discussionsDiscussionIdMessagesPost(discussionId, messageDTO);
        // TODO: test validations
    }

    /**
     * Get a list of all discussions
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void discussionsGetTest() throws ApiException {
        List<DiscussionDTO> response = api.discussionsGet();
        // TODO: test validations
    }

}

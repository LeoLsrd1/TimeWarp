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


package org.openapitools.client.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Model tests for PostMessageDTO
 */
public class PostMessageDTOTest {

  /**
   * Model tests for PostMessageDTO
   */
  @Test
  public void testPostMessageDTO() {
    // Create an instance of PostMessageDTO with example values
    PostMessageDTO message = new PostMessageDTO();
    message.setTo("bob@acme");
    message.setType("text/plain");
    message.setBody("This is the message");

    // Check that the properties have been correctly set
    assertEquals("bob@acme", message.getTo());
    assertEquals("text/plain", message.getType());
    assertEquals("This is the message", message.getBody());
  }

  /**
   * Test the property 'to'
   */
  @Test
  public void toTest() {
    // Create an instance of PostMessageDTO and set the 'to' property
    PostMessageDTO message = new PostMessageDTO();
    message.setTo("bob@acme");

    // Check that the 'to' property has been correctly set
    assertEquals("bob@acme", message.getTo());
  }

  /**
   * Test the property 'type'
   */
  @Test
  public void typeTest() {
    // Create an instance of PostMessageDTO and set the 'type' property
    PostMessageDTO message = new PostMessageDTO();
    message.setType("text/plain");

    // Check that the 'type' property has been correctly set
    assertEquals("text/plain", message.getType());
  }

  /**
   * Test the property 'body'
   */
  @Test
  public void bodyTest() {
    // Create an instance of PostMessageDTO and set the 'body' property
    PostMessageDTO message = new PostMessageDTO();
    message.setBody("This is the message");

    // Check that the 'body' property has been correctly set
    assertEquals("This is the message", message.getBody());
  }

}

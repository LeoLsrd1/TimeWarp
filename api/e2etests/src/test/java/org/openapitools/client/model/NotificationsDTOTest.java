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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Model tests for NotificationsDTO
 */
public class NotificationsDTOTest {
  private final NotificationsDTO model = new NotificationsDTO();

  /**
   * Model tests for NotificationsDTO
   */
  @Test
  public void testNotificationsDTO() {
    NotificationsDTO n = new NotificationsDTO();
    n.setBadges(true);
    n.setSounds(false);

    assertEquals(true, n.getBadges());
    assertEquals(false, n.getSounds());
  }

  /**
   * Test the property 'sounds'
   */
  @Test
  public void soundsTest() {
    NotificationsDTO n = new NotificationsDTO();
    n.setSounds(true);
    assertEquals(true, n.getSounds());
  }

  /**
   * Test the property 'badges'
   */
  @Test
  public void badgesTest() {
    NotificationsDTO n = new NotificationsDTO();
    n.setBadges(false);
    assertEquals(false, n.getBadges());
  }

}

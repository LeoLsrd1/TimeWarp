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

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Arrays;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openapitools.client.JSON;

/**
 * UserSettingsDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class UserSettingsDTO {
  public static final String SERIALIZED_NAME_THEME = "theme";
  @SerializedName(SERIALIZED_NAME_THEME)
  private String theme;

  public static final String SERIALIZED_NAME_LANGUAGE = "language";
  @SerializedName(SERIALIZED_NAME_LANGUAGE)
  private String language;

  public static final String SERIALIZED_NAME_UNREAD_BADGES = "UnreadBadges";
  @SerializedName(SERIALIZED_NAME_UNREAD_BADGES)
  private Boolean unreadBadges;

  public static final String SERIALIZED_NAME_NOTIFICATION_SOUND = "NotificationSound";
  @SerializedName(SERIALIZED_NAME_NOTIFICATION_SOUND)
  private Boolean notificationSound;

  public static final String SERIALIZED_NAME_PROFILE_IMAGE = "profileImage";
  @SerializedName(SERIALIZED_NAME_PROFILE_IMAGE)
  private String profileImage;

  public UserSettingsDTO() {
  }

  public UserSettingsDTO theme(String theme) {
    
    this.theme = theme;
    return this;
  }

   /**
   * Get theme
   * @return theme
  **/
  @javax.annotation.Nullable
  public String getTheme() {
    return theme;
  }


  public void setTheme(String theme) {
    this.theme = theme;
  }


  public UserSettingsDTO language(String language) {
    
    this.language = language;
    return this;
  }

   /**
   * Get language
   * @return language
  **/
  @javax.annotation.Nullable
  public String getLanguage() {
    return language;
  }


  public void setLanguage(String language) {
    this.language = language;
  }


  public UserSettingsDTO unreadBadges(Boolean unreadBadges) {
    
    this.unreadBadges = unreadBadges;
    return this;
  }

   /**
   * Get unreadBadges
   * @return unreadBadges
  **/
  @javax.annotation.Nullable
  public Boolean getUnreadBadges() {
    return unreadBadges;
  }


  public void setUnreadBadges(Boolean unreadBadges) {
    this.unreadBadges = unreadBadges;
  }


  public UserSettingsDTO notificationSound(Boolean notificationSound) {
    
    this.notificationSound = notificationSound;
    return this;
  }

   /**
   * Get notificationSound
   * @return notificationSound
  **/
  @javax.annotation.Nullable
  public Boolean getNotificationSound() {
    return notificationSound;
  }


  public void setNotificationSound(Boolean notificationSound) {
    this.notificationSound = notificationSound;
  }


  public UserSettingsDTO profileImage(String profileImage) {
    
    this.profileImage = profileImage;
    return this;
  }

   /**
   * Get profileImage
   * @return profileImage
  **/
  @javax.annotation.Nullable
  public String getProfileImage() {
    return profileImage;
  }


  public void setProfileImage(String profileImage) {
    this.profileImage = profileImage;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserSettingsDTO userSettingsDTO = (UserSettingsDTO) o;
    return Objects.equals(this.theme, userSettingsDTO.theme) &&
        Objects.equals(this.language, userSettingsDTO.language) &&
        Objects.equals(this.unreadBadges, userSettingsDTO.unreadBadges) &&
        Objects.equals(this.notificationSound, userSettingsDTO.notificationSound) &&
        Objects.equals(this.profileImage, userSettingsDTO.profileImage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(theme, language, unreadBadges, notificationSound, profileImage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserSettingsDTO {\n");
    sb.append("    theme: ").append(toIndentedString(theme)).append("\n");
    sb.append("    language: ").append(toIndentedString(language)).append("\n");
    sb.append("    unreadBadges: ").append(toIndentedString(unreadBadges)).append("\n");
    sb.append("    notificationSound: ").append(toIndentedString(notificationSound)).append("\n");
    sb.append("    profileImage: ").append(toIndentedString(profileImage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


  public static HashSet<String> openapiFields;
  public static HashSet<String> openapiRequiredFields;

  static {
    // a set of all properties/fields (JSON key names)
    openapiFields = new HashSet<String>();
    openapiFields.add("theme");
    openapiFields.add("language");
    openapiFields.add("UnreadBadges");
    openapiFields.add("NotificationSound");
    openapiFields.add("profileImage");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to UserSettingsDTO
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!UserSettingsDTO.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in UserSettingsDTO is not found in the empty JSON string", UserSettingsDTO.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!UserSettingsDTO.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `UserSettingsDTO` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("theme") != null && !jsonObj.get("theme").isJsonNull()) && !jsonObj.get("theme").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `theme` to be a primitive type in the JSON string but got `%s`", jsonObj.get("theme").toString()));
      }
      if ((jsonObj.get("language") != null && !jsonObj.get("language").isJsonNull()) && !jsonObj.get("language").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `language` to be a primitive type in the JSON string but got `%s`", jsonObj.get("language").toString()));
      }
      if ((jsonObj.get("profileImage") != null && !jsonObj.get("profileImage").isJsonNull()) && !jsonObj.get("profileImage").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `profileImage` to be a primitive type in the JSON string but got `%s`", jsonObj.get("profileImage").toString()));
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!UserSettingsDTO.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'UserSettingsDTO' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<UserSettingsDTO> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(UserSettingsDTO.class));

       return (TypeAdapter<T>) new TypeAdapter<UserSettingsDTO>() {
           @Override
           public void write(JsonWriter out, UserSettingsDTO value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public UserSettingsDTO read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of UserSettingsDTO given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of UserSettingsDTO
  * @throws IOException if the JSON string is invalid with respect to UserSettingsDTO
  */
  public static UserSettingsDTO fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, UserSettingsDTO.class);
  }

 /**
  * Convert an instance of UserSettingsDTO to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.client.model.MessageDTO;

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
 * DiscussionDTO
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class DiscussionDTO {
  public static final String SERIALIZED_NAME_ID = "id";
  @SerializedName(SERIALIZED_NAME_ID)
  private UUID id;

  public static final String SERIALIZED_NAME_USER1 = "user1";
  @SerializedName(SERIALIZED_NAME_USER1)
  private String user1;

  public static final String SERIALIZED_NAME_USER2 = "user2";
  @SerializedName(SERIALIZED_NAME_USER2)
  private String user2;

  public static final String SERIALIZED_NAME_MESSAGES = "messages";
  @SerializedName(SERIALIZED_NAME_MESSAGES)
  private List<MessageDTO> messages;

  public DiscussionDTO() {
  }

  public DiscussionDTO id(UUID id) {
    
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @javax.annotation.Nullable
  public UUID getId() {
    return id;
  }


  public void setId(UUID id) {
    this.id = id;
  }


  public DiscussionDTO user1(String user1) {
    
    this.user1 = user1;
    return this;
  }

   /**
   * Get user1
   * @return user1
  **/
  @javax.annotation.Nullable
  public String getUser1() {
    return user1;
  }


  public void setUser1(String user1) {
    this.user1 = user1;
  }


  public DiscussionDTO user2(String user2) {
    
    this.user2 = user2;
    return this;
  }

   /**
   * Get user2
   * @return user2
  **/
  @javax.annotation.Nullable
  public String getUser2() {
    return user2;
  }


  public void setUser2(String user2) {
    this.user2 = user2;
  }


  public DiscussionDTO messages(List<MessageDTO> messages) {
    
    this.messages = messages;
    return this;
  }

  public DiscussionDTO addMessagesItem(MessageDTO messagesItem) {
    if (this.messages == null) {
      this.messages = new ArrayList<>();
    }
    this.messages.add(messagesItem);
    return this;
  }

   /**
   * Get messages
   * @return messages
  **/
  @javax.annotation.Nullable
  public List<MessageDTO> getMessages() {
    return messages;
  }


  public void setMessages(List<MessageDTO> messages) {
    this.messages = messages;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscussionDTO discussionDTO = (DiscussionDTO) o;
    return Objects.equals(this.id, discussionDTO.id) &&
        Objects.equals(this.user1, discussionDTO.user1) &&
        Objects.equals(this.user2, discussionDTO.user2) &&
        Objects.equals(this.messages, discussionDTO.messages);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, user1, user2, messages);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscussionDTO {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    user1: ").append(toIndentedString(user1)).append("\n");
    sb.append("    user2: ").append(toIndentedString(user2)).append("\n");
    sb.append("    messages: ").append(toIndentedString(messages)).append("\n");
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
    openapiFields.add("id");
    openapiFields.add("user1");
    openapiFields.add("user2");
    openapiFields.add("messages");

    // a set of required properties/fields (JSON key names)
    openapiRequiredFields = new HashSet<String>();
  }

 /**
  * Validates the JSON Element and throws an exception if issues found
  *
  * @param jsonElement JSON Element
  * @throws IOException if the JSON Element is invalid with respect to DiscussionDTO
  */
  public static void validateJsonElement(JsonElement jsonElement) throws IOException {
      if (jsonElement == null) {
        if (!DiscussionDTO.openapiRequiredFields.isEmpty()) { // has required fields but JSON element is null
          throw new IllegalArgumentException(String.format("The required field(s) %s in DiscussionDTO is not found in the empty JSON string", DiscussionDTO.openapiRequiredFields.toString()));
        }
      }

      Set<Map.Entry<String, JsonElement>> entries = jsonElement.getAsJsonObject().entrySet();
      // check to see if the JSON string contains additional fields
      for (Map.Entry<String, JsonElement> entry : entries) {
        if (!DiscussionDTO.openapiFields.contains(entry.getKey())) {
          throw new IllegalArgumentException(String.format("The field `%s` in the JSON string is not defined in the `DiscussionDTO` properties. JSON: %s", entry.getKey(), jsonElement.toString()));
        }
      }
        JsonObject jsonObj = jsonElement.getAsJsonObject();
      if ((jsonObj.get("id") != null && !jsonObj.get("id").isJsonNull()) && !jsonObj.get("id").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `id` to be a primitive type in the JSON string but got `%s`", jsonObj.get("id").toString()));
      }
      if ((jsonObj.get("user1") != null && !jsonObj.get("user1").isJsonNull()) && !jsonObj.get("user1").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user1` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user1").toString()));
      }
      if ((jsonObj.get("user2") != null && !jsonObj.get("user2").isJsonNull()) && !jsonObj.get("user2").isJsonPrimitive()) {
        throw new IllegalArgumentException(String.format("Expected the field `user2` to be a primitive type in the JSON string but got `%s`", jsonObj.get("user2").toString()));
      }
      if (jsonObj.get("messages") != null && !jsonObj.get("messages").isJsonNull()) {
        JsonArray jsonArraymessages = jsonObj.getAsJsonArray("messages");
        if (jsonArraymessages != null) {
          // ensure the json data is an array
          if (!jsonObj.get("messages").isJsonArray()) {
            throw new IllegalArgumentException(String.format("Expected the field `messages` to be an array in the JSON string but got `%s`", jsonObj.get("messages").toString()));
          }

          // validate the optional field `messages` (array)
          for (int i = 0; i < jsonArraymessages.size(); i++) {
            MessageDTO.validateJsonElement(jsonArraymessages.get(i));
          };
        }
      }
  }

  public static class CustomTypeAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
       if (!DiscussionDTO.class.isAssignableFrom(type.getRawType())) {
         return null; // this class only serializes 'DiscussionDTO' and its subtypes
       }
       final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
       final TypeAdapter<DiscussionDTO> thisAdapter
                        = gson.getDelegateAdapter(this, TypeToken.get(DiscussionDTO.class));

       return (TypeAdapter<T>) new TypeAdapter<DiscussionDTO>() {
           @Override
           public void write(JsonWriter out, DiscussionDTO value) throws IOException {
             JsonObject obj = thisAdapter.toJsonTree(value).getAsJsonObject();
             elementAdapter.write(out, obj);
           }

           @Override
           public DiscussionDTO read(JsonReader in) throws IOException {
             JsonElement jsonElement = elementAdapter.read(in);
             validateJsonElement(jsonElement);
             return thisAdapter.fromJsonTree(jsonElement);
           }

       }.nullSafe();
    }
  }

 /**
  * Create an instance of DiscussionDTO given an JSON string
  *
  * @param jsonString JSON string
  * @return An instance of DiscussionDTO
  * @throws IOException if the JSON string is invalid with respect to DiscussionDTO
  */
  public static DiscussionDTO fromJson(String jsonString) throws IOException {
    return JSON.getGson().fromJson(jsonString, DiscussionDTO.class);
  }

 /**
  * Convert an instance of DiscussionDTO to an JSON string
  *
  * @return JSON string
  */
  public String toJson() {
    return JSON.getGson().toJson(this);
  }
}


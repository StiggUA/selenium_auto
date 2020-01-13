package com.auto.APITests;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "birthDate",
        "id",
        "name",
        "owner",
        "type",
        "visits"
})
public class NewPet {
        @JsonProperty("birthDate")
        private String birthDate;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("owner")
        private NewOwner owner;
        @JsonProperty("type")
        private Type type;
        @JsonProperty("visits")
        private List<Visit> visits = null;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("birthDate")
        public String getBirthDate() {
            return birthDate;
        }

        @JsonProperty("birthDate")
        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        @JsonProperty("name")
        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("owner")
        public NewOwner getOwner() {
            return owner;
        }

        @JsonProperty("owner")
        public void setOwner(NewOwner owner) {
            this.owner = owner;
        }

        @JsonProperty("type")
        public Type getType() {
            return type;
        }

        @JsonProperty("type")
        public void setType(Type type) {
            this.type = type;
        }

        @JsonProperty("visits")
        public List<Visit> getVisits() {
            return visits;
        }

        @JsonProperty("visits")
        public void setVisits(List<Visit> visits) {
            this.visits = visits;
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

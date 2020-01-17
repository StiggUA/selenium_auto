package com.auto.APITests.Owner;
import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "description",
        "id",
        "pet"
})
public class NewVisit {
        @JsonProperty("date")
        private String date;
        @JsonProperty("description")
        private String description;
        @JsonProperty("id")
        private Integer id;
        @JsonProperty("pet")
        private NewPet pet;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        @JsonProperty("date")
        public String getDate() {
            return date;
        }

        @JsonProperty("date")
        public void setDate(String date) {
            this.date = date;
        }

        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        @JsonProperty("id")
        public Integer getId() {
            return id;
        }

        @JsonProperty("id")
        public void setId(Integer id) {
            this.id = id;
        }

        @JsonProperty("pet")
        public NewPet getPet() {
            return pet;
        }

        @JsonProperty("pet")
        public void setPet(NewPet pet) {
            this.pet = pet;
        }

    }
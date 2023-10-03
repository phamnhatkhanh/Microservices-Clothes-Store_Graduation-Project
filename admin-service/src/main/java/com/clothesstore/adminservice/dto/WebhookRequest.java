package com.clothesstore.adminservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookRequest {
    private Webhook webhook;

    public WebhookRequest(String address, String topic, String format) {
        this.webhook = new Webhook(address, topic, format);
    }

    public static class Webhook {
        private String address;
        private String topic;
        private String format;

        public Webhook(String address, String topic, String format) {
            this.address = address;
            this.topic = topic;
            this.format = format;
        }

        @JsonProperty("address")
        public String getAddress() {
            return address;
        }

        @JsonProperty("topic")
        public String getTopic() {
            return topic;
        }

        @JsonProperty("format")
        public String getFormat() {
            return format;
        }
    }
}

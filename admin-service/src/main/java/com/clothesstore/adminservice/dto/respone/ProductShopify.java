package com.clothesstore.adminservice.dto.respone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductShopify {
    private long id;
    private String title;
    private String body_html;
    private String vendor;
    private String product_type;
    private String created_at;
    private String handle;
    private String updated_at;
    private String published_at;
    private String template_suffix;
    private String published_scope;
    private String tags;
    private String status;
    private String admin_graphql_api_id;
    private List<Variant> variants;
    private List<Option> options;
    private List<Image> images;
    private Image image;

    // Getters and setters

    public static class Variant {
        private long id;
        private long product_id;
        private String title;
        private String price;
        private String sku;
        // Other fields as needed

        // Getters and setters
    }

    public static class Option {
        private long id;
        private long product_id;
        private String name;
        private int position;
        private List<String> values;

        // Getters and setters
    }

    public static class Image {
        private long id;
        private long product_id;
        private int position;
        private String created_at;
        private String updated_at;
        private String alt;
        private int width;
        private int height;
        private String src;
        private List<Long> variant_ids;
        private String admin_graphql_api_id;

        // Getters and setters
    }
}

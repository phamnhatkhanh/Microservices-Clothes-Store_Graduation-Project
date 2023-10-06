package com.clothesstore.adminservice.enums;




public enum ShopifyEnvironment {
    STORE_URL("shopify.domain.store"),
    ROOT_LINK("shopify.api.root"),
    ADDRESS_WEBHOOK("shopify.api.address.webhook"),
    LIST_WEBHOOK("shopify.store.list.id.webhook"),
    SERCRET_KEY("shopify.key.sercret"),
    ACCESS_TOKEN("shopify.access.token"),
    HEADER_TOKEN("shopify.header.token"),
    HEADER_HMAC("shopify.header.hmac"),
    TOPICS_PERMISSION("shopify.store.access.permission");




    private String variableEnviroment;


//    @Autowired
    private ShopifyEnvironment(String variableEnviroment) {
        this.variableEnviroment = variableEnviroment;
    }

    public String getValue() {
        return variableEnviroment;
    }
}

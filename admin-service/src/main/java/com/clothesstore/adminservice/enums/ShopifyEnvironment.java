package com.clothesstore.adminservice.enums;




public enum ShopifyEnvironment {
    STORE_URL("shopify.domain.store"),
    ROOT_LINK("shopify.api.root.link"),
    ADDRESS_WEBHOOK("shopify.api.address.webhook"),
    ACCESS_TOKEN("shopify.access.token"),
    HEADER_TOKEN("shopify.header.token"),
    TOPICS_PERMISSION("shopify.store.access.permission"),
    LIST_WEBHOOK("shopify.store.list.id.webhook");



    private String variableEnviroment;


//    @Autowired
    private ShopifyEnvironment(String variableEnviroment) {
        this.variableEnviroment = variableEnviroment;
    }

    public String getValue() {
        return variableEnviroment;
    }
}

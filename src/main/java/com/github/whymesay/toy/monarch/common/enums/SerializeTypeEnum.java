package com.github.whymesay.toy.monarch.common.enums;

/**
 * @author whymesay
 * @date 2020/10/3 18:09
 */
public enum SerializeTypeEnum implements BaseEnum {

    /**
     * json
     */
    JSON(1, "json"),
    ;
    private Integer value;
    private String description;

    SerializeTypeEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

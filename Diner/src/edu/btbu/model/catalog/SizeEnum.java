package edu.btbu.model.catalog;

public enum SizeEnum {
    STANDARD("标准"),EXTRA_SMALL("超小号"), SMALL("小号"), MEDIUM("中号"), BIG("大号");
    //    private String name;
    private String alias;

    private SizeEnum(String alias) {
        this.alias = alias;
    }
    public String alias(){
        return alias;
    }
}

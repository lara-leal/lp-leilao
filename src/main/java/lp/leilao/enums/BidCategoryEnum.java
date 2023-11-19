package lp.leilao.enums;

public enum BidCategoryEnum {


    DEVICE("DEVICE"),
    VEHICLE("VEHICLE");

    public String status;

    BidCategoryEnum(String status) {
        this.status = status;
    }
}

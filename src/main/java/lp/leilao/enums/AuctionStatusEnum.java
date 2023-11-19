package lp.leilao.enums;

public enum AuctionStatusEnum {
    OPEN("OPEN"),
    IN_PROGRESS("IN_PROGRESS"),
    FINISHED("FINISHED"),
    INACTIVE("INACTIVE");

    public String status;

    AuctionStatusEnum(String status) {
        this.status = status;
    }
}

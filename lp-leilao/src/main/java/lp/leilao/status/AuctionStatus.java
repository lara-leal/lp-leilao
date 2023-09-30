package lp.leilao.status;

public enum AuctionStatus {
    OPEN("Open"),
    IN_PROGRESS("In progress"),
    CLOSED("Closed");

    public String status;

    AuctionStatus(String status) {
        this.status = status;
    }
}


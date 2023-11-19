package lp.leilao.enums;

public enum DevicesTypeEnum {
    NOTEBOOK("notebook"),
    MONITOR("monitor"),
    HUB("hub"),
    ROUTER("router"),
    SWITCHES("switche");

    public String status;

    DevicesTypeEnum(String status) {
        this.status = status;
    }

}

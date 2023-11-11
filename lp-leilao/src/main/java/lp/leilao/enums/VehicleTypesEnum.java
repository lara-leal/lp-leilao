package lp.leilao.enums;

public enum VehicleTypesEnum {
    TRUCK("truck"),
    MOTORCYCLE("motorcycle"),
    CAR("car"),
    VAN("van"),
    BUS("bus");

    public String status;

    VehicleTypesEnum(String status) {
        this.status = status;
    }
}

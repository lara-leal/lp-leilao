package lp.leilao.enums;

import lombok.Getter;



@Getter
public enum CategoryEnums {
    VEHICLE("vehicle"),
    DEVICE("device"),
    BOTH("both");

    public String status;

    CategoryEnums(String status) {
        this.status = status;
    }
}


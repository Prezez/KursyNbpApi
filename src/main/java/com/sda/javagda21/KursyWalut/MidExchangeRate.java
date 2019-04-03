package com.sda.javagda21.KursyWalut;

import lombok.Data;

@Data
public class MidExchangeRate {

    private String table;
    private String currency;
    private String code;
    private MidRate [] rates;

}



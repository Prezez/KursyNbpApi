package com.sda.javagda21.KursyWalut;

import lombok.Data;

@Data
public class BuySellExchangeRate {

    private String table;
    private String currency;
    private String code;
    private BuySellRate [] rates;
}

package domain.enums;

public enum Stock implements Symbol {
    WMT("Walmart Inc."),
    VZ("Verizon Communications Inc."),
    DIS("The Walt Disney Company"),
    PG("The Procter & Gamble Company"),
    HD("The Home Depot, Inc."),
    KO("The Coca-Cola Company"),
    BA("The Boeing Company"),
    TSLA("Tesla, Inc."),
    PFE("Pfizer Inc."),
    NFLX("Netflix, Inc."),
    NVDA("NVIDIA Corporation"),
    MSFT("Microsoft Corporation"),
    MCD("McDonald's Corporation"),
    JNJ("Johnson & Johnson"),
    JPM("JPMorgan Chase & Co."),
    IBM("International Business Machines Corporation"),
    INTC("Intel Corporation"),
    GE("General Electric Company"),
    F("Ford Motor Company"),
    FB("Facebook, Inc."),
    XOM("Exxon Mobil Corporation"),
    C("Citigroup Inc."),
    CSCO("Cisco Systems, Inc."),
    BAC("Bank of America Corporation"),
    AAPL("Apple Inc."),
    AMZN("Amazon.com, Inc."),
    GOOG("Alphabet Inc."),
    BABA("Alibaba Group Holding Limited"),
    AMD("Advanced Micro Devices, Inc."),
    T("AT&T Inc.");

    public String name;

    Stock(String name) {
        this.name = name;
    }

    @Override
    public String getSymbol()  {
        return this.name();
    }
}

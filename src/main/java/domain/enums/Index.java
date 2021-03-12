package domain.enums;

public enum Index implements Symbol {
    ES("S&P Futures"),
    YM("Dow Futures"),
    NQ("Nasdaq Futures"),
    RTY("Russell 2000 Futures"),
    GC("Gold"),
    DX("US Dollar");

    public String name;

    Index(String name) {
        this.name = name;
    }

    @Override
    public String getSymbol()  {
        return this.name().concat(IDX_SUFFIX);
    }
}

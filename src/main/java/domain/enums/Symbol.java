package domain.enums;

public interface Symbol {
    String IDX_SUFFIX = "=F";
    String getSymbol();

    static Symbol parse(String name) {
        if (name.contains(IDX_SUFFIX)) {
            return Index.valueOf(name.replace(IDX_SUFFIX,  ""));
        }

        return Stock.valueOf(name);
    }
}

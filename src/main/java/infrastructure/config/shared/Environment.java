package infrastructure.config.shared;

public enum Environment {
    ALPHA("alpha"),
    DEV("dev"),
    STAGING("staging"),
    PROD("prod"),
    TEST("test") {
        public Environment setId(String id) {
            this.id = id;
            return this;
        }
    },
    CUSTOM("custom") {
        public Environment setId(String id) {
            this.id = id;
            return this;
        }
    };

    protected String id;

    Environment(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }

    public Environment setId(String id) {
        throw new UnsupportedOperationException("Cannot change the ID of most Environments");
    }
}


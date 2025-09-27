public class College {
    private String name;
    private boolean hasLibrary;
    private boolean hasHostel;
    private boolean hasSportsComplex;
    private boolean hasLabs;

    // Private constructor to force use of Builder
    private College(Builder builder) {
        this.name = builder.name;
        this.hasLibrary = builder.hasLibrary;
        this.hasHostel = builder.hasHostel;
        this.hasSportsComplex = builder.hasSportsComplex;
        this.hasLabs = builder.hasLabs;
    }

    @Override
    public String toString() {
        return "College [name=" + name +
               ", Library=" + hasLibrary +
               ", Hostel=" + hasHostel +
               ", SportsComplex=" + hasSportsComplex +
               ", Labs=" + hasLabs + "]";
    }

    // Static Builder Class
    public static class Builder {
        private String name;
        private boolean hasLibrary;
        private boolean hasHostel;
        private boolean hasSportsComplex;
        private boolean hasLabs;

        public Builder(String name) {
            this.name = name;
        }

        public Builder addLibrary() {
            this.hasLibrary = true;
            return this;
        }

        public Builder addHostel() {
            this.hasHostel = true;
            return this;
        }

        public Builder addSportsComplex() {
            this.hasSportsComplex = true;
            return this;
        }

        public Builder addLabs() {
            this.hasLabs = true;
            return this;
        }

        public College build() {
            return new College(this);
        }
    }
}

package subway.config.constants.views;

public enum Prefixes {
    SHARP("## "),
    INFO("[INFO] "),
    ERROR("[ERROR] ");
    private final String prefix;
    Prefixes(String prefix){
        this.prefix=prefix;
    }
    public String getPrefix(){
        return this.prefix;
    }
}

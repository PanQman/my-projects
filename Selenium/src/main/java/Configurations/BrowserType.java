package Configurations;

public enum BrowserType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("internetexplorer");

    private String browser;

    BrowserType(String browser){
        this.browser = browser;
    }
}

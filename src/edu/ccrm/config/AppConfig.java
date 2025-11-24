package edu.ccrm.config;

public class AppConfig {
    private static AppConfig instance = null;
    private String dataFolderPath;

    private AppConfig() {
        dataFolderPath = "data";
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    public String getDataFolderPath() {
        return dataFolderPath;
    }

    public void setDataFolderPath(String dataFolderPath) {
        this.dataFolderPath = dataFolderPath;
    }
}

package db;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.runtime.ObjectMethods;
import java.nio.file.Path;

public class DatabaseConfigProperties {
    private String url;
    private String username;
    private String password;

    public DatabaseConfigProperties() {
        ObjectMapper  mapper = new ObjectMapper();
        Path path =Path.of("C:\\Users\\Daniel Genesis\\Desktop\\D-Genesis-repo\\project_holiday\\jdbcAccountManagementApp\\src\\config.json");;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

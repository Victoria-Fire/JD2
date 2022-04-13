package by.it.academy.jd2.reunova;

import java.util.ResourceBundle;

public class JDBCResource {
    public static final String DATABASE_RESOURCE = "homework_6";
    public static final String URL_KEY = "url";
    public static final String USER_KEY = "username";
    public static final String PASSWORD_KEY = "password";

    private static final ResourceBundle RESOURCE = ResourceBundle.getBundle(DATABASE_RESOURCE);

    private static final String URL = getValue(URL_KEY);
    private static final String USER = getValue(USER_KEY);
    private static final String PASSWORD = getValue(PASSWORD_KEY);

    public static String getValue(String key) {
        return RESOURCE.getString(key);
    }

    public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }
}

package org.example.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * create by 103style on 2024/12/14 14:31
 */
public class ResourceI18nTest {

    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", new Locale("zh", "CN"));
        System.out.println(resourceBundle.getString("test"));

        ResourceBundle resourceBundleEN = ResourceBundle.getBundle("messages", new Locale("en", "GB"));
        System.out.println(resourceBundleEN.getString("test"));
    }
}

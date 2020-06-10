package elsevier.uk.entellect.platform.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class PropUtils {

    private PropUtils () {}

    public static void set(String property, String value) {
        value = hidePasswords(property, value);
        System.out.println(String.format("%n[INFO] PROPERTY SET: %s=%s%n", property, value));
        System.setProperty(property, value);
    }

    public static Optional<String> get(String property) {
        Optional<String> propValue = Optional.empty();

        if (System.getenv(property) != null) {
            propValue = Optional.of(System.getenv(property));
        } else if (System.getProperty(property) != null) {
            propValue = Optional.of(System.getProperty(property));
        }

        if (propValue.isPresent()){
            String sanitised = hidePasswords(property, propValue.get());
            System.out.println(String.format("%n[INFO] PROPERTY RETRIEVED: %s=%s%n", property, sanitised));
        }

        return propValue;
    }

    public static boolean has(String property) {
        return PropUtils.get(property).isPresent();
    }

    private static String hidePasswords(String property, String value) {
        return StringUtils.containsIgnoreCase(property, "password") && !value.isEmpty() ? value.replaceAll("\\w", "*") : value ;
    }

}

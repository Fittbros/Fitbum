package com.fitbum.util;

import org.springframework.context.annotation.Bean;

import java.util.regex.Pattern;

public class ValidarFormatoPassword {
    private static final String PASSWORD_REGEX =
            "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$";

    private static final String COMPLEX_PASSWORD_REGEX =
            "^(?:(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])|" +
                    "(?=.*\\d)(?=.*[^A-Za-z0-9])(?=.*[a-z])|" +
                    "(?=.*[^A-Za-z0-9])(?=.*[A-Z])(?=.*[a-z])|" +
                    "(?=.*\\d)(?=.*[A-Z])(?=.*[^A-Za-z0-9]))(?!.*(.)\\1{2,})" +
                    "[A-Za-z0-9!~<>,;:_=?*+#.\"&§%°()\\|\\[\\]\\-\\$\\^\\@\\/]" +
                    "{8,32}$";

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(COMPLEX_PASSWORD_REGEX);
    @Bean
    public static boolean ValidarFormato(String password){
        if (PASSWORD_PATTERN.matcher(password).matches()) {
            return true;
        }
        else {
            return false;
        }
    }
}

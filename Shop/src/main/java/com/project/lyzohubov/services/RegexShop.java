package com.project.lyzohubov.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexShop {
    private Pattern patternName = Pattern.compile("Lg||Hp||Samsung||Lenovo||Asus||Razer||Xiomi||Dell");
    private Pattern patternCommands = Pattern.compile("[0-9]");


    public Boolean checkInputCommand(String idName) {
        Matcher matcher = patternName.matcher(idName);
        return matcher.matches();
    }

    public Boolean checkInputCommand(int input) {
        Matcher matcher = patternCommands.matcher(String.valueOf(input));
        return matcher.matches();
    }

}

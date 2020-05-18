package com.burakenesdemir.cms.model.enums;

public enum HtmlNames {
    RESET_PASSWORD_MAIL(Names.RESET_PASSWORD_MAIL);


    private String name;

    HtmlNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Names {
        static final String RESET_PASSWORD_MAIL = "mailResetPassword.html";
    }
}

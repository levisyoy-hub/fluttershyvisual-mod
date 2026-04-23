package ru.fluttershy.visual.module;

public enum Category {
    RENDER("RENDER"),
    HELPER("HELPER"),
    VISUALS("VISUALS"),
    GAMEPLAY("GAMEPLAY");

    public final String name;

    Category(String name) {
        this.name = name;
    }
}

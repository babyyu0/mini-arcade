package com.mini.arcade.enums;

public enum SuccessStatus {
    NONE(0),
    SUCCEED(1),
    FAIL(2);


    private final int value;

    SuccessStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

}

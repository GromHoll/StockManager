package com.stockControl.db;

/**
 * Created with IntelliJ IDEA.
 * User: GromHoll
 * Date: 01.08.13
 * Time: 2:31
 * To change this template use File | Settings | File Templates.
 */
public enum Condition {
    EQUAL("=") {
        boolean compare(long arg1, long arg2) {
            return arg1 == arg2;
        }
    },
    NOT_EQUAL("!=") {
        boolean compare(long arg1, long arg2) {
            return arg1 != arg2;
        }
    },
    GREATER(">") {
        boolean compare(long arg1, long arg2) {
            return arg1 > arg2;
        }
    },
    GREATER_OR_EQUAL(">=") {
        boolean compare(long arg1, long arg2) {
            return arg1 >= arg2;
        }
    },
    LESS("<") {
        boolean compare(long arg1, long arg2) {
            return arg1 < arg2;
        }
    },
    LESS_OR_EQUAL("<=") {
        boolean compare(long arg1, long arg2) {
            return arg1 <= arg2;
        }
    };

    private String view;

    Condition(String view) {
        this.view = view;
    }

    abstract boolean compare(long arg1, long arg2);
}

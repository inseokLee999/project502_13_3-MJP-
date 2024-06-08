package org.choongang.global;

/**
 * 필수 항목 체크
 *
 */
public interface RequiredValidator {
    default void checkRequired(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }
}
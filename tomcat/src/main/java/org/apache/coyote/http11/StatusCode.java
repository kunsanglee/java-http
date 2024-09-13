package org.apache.coyote.http11;

import java.util.Arrays;

public enum StatusCode {
    OK(200, "OK"),
    FOUND(302, "FOUND"),
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    NOT_FOUND(404, "NOT_FOUND"),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR"),
    ;

    private final int code;
    private final String reasonPhrase;

    StatusCode(int code, String reasonPhrase) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
    }

    public static StatusCode valueOf(int code) {
        return Arrays.stream(values())
                .filter(statusCode -> statusCode.code == code)
                .findAny()
                .orElseThrow();
    }

    public String getStatusCode() {
        return code + " " + reasonPhrase;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "code=" + code +
                ", reasonPhrase='" + reasonPhrase + '\'' +
                '}';
    }
}

package com.softserve.library.app.http;

import javax.annotation.Nullable;

public class CustomResponseEntity<T> {

    private T responseBody;
    private int httpStatusCode;

    /**
     * Create a new {@code CustomResponseEntity} with the given status code, and no body.
     *
     * @param httpStatusCode the http status code
     */
    public CustomResponseEntity(int httpStatusCode) {
        this(null, httpStatusCode);
    }

    /**
     * Create a new {@code CustomResponseEntity} with the given body and status code.
     *
     * @param responseBody   the entity body
     * @param httpStatusCode the http status code
     */
    public CustomResponseEntity(@Nullable T responseBody, int httpStatusCode) {
        this.responseBody = responseBody;
        this.httpStatusCode = httpStatusCode;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}


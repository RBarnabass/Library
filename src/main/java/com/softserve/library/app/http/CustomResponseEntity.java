package com.softserve.library.app.http;

public class CustomResponseEntity<T> {

    private T responseBody;
    private HttpStatus httpStatus;

    /**
     * Create a new {@code CustomResponseEntity} with the given status code, and no body.
     *
     * @param httpStatus the http status code
     */
    public CustomResponseEntity(HttpStatus httpStatus) {
        this(null, httpStatus);
    }

    /**
     * Create a new {@code CustomResponseEntity} with the given body and status code.
     *
     * @param responseBody   the entity body
     * @param httpStatus the http status code
     */
    public CustomResponseEntity(T responseBody, HttpStatus httpStatus) {
        this.responseBody = responseBody;
        this.httpStatus = httpStatus;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}


package org.apache.coyote.http11;

public class StartLine {

    private static final String START_LINE_DELIMITER = " ";

    private final HttpMethod httpMethod;
    private final RequestUri requestUri;
    private final HttpVersion httpVersion;

    public StartLine(HttpMethod httpMethod, RequestUri requestUri, HttpVersion httpVersion) {
        this.httpMethod = httpMethod;
        this.requestUri = requestUri;
        this.httpVersion = httpVersion;
    }

    public static StartLine from(String startLine) {
        String[] splitStartLine = startLine.split(START_LINE_DELIMITER);
        HttpMethod httpMethod = HttpMethod.from(splitStartLine[0]);
        RequestUri requestUri = RequestUri.from(splitStartLine[1]);
        HttpVersion httpVersion = HttpVersion.from(splitStartLine[2]);

        return new StartLine(httpMethod, requestUri, httpVersion);
    }

    public String getRequestUri() {
        return requestUri.getRequestUri();
    }

    public String getHttpVersion() {
        return httpVersion.toString();
    }
}

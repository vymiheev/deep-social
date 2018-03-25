package com.ecpi.youtube.ex;

public class YoutubeDefaultException extends Exception {
    public YoutubeDefaultException() {
    }

    public YoutubeDefaultException(String message) {
        super(message);
    }

    public YoutubeDefaultException(String message, Throwable cause) {
        super(message, cause);
    }

    public YoutubeDefaultException(Throwable cause) {
        super(cause);
    }

    public YoutubeDefaultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package com.sdirect.sports.network;

public class ResponseCodes {

    /** System Level Response Codes Starts Here **/

    /**
     * The Constant Success.
     */
    public static final int Success = 200;

    /**
     * The Constant Success.
     */
    public static final int Accepted = 201;

    /**
     * The Constant AccessToken expired.
     */
    public static final int ACCESS_TOKEN_EXPIRED = 401;

    /**
     * The Constant RefreshToken expired.
     */
    public static final int REFRESH_TOKEN_EXPIRED = 400;

    /**
     * The Constant InvalidUseridPassword
     */
    public static final int BAD_REQUEST = 400;


    // Error Codes
    public static final int REQUEST_CANCEL = -1;
    public static final int RESPONSE_JSON_NOT_VALID = 1;
    public static final int MODEL_TYPE_CAST_EXCEPTION = 2;
    public static final int INTERNET_NOT_AVAILABLE = 3;
    public static final int WRONG_URL = 4;
    public static final int WRONG_METHOD_NAME = 5;
    public static final int URL_CONNECTION_ERROR = 6;
    public static final int UNKNOWN_ERROR = 10;

    public static final int NOT_ALLOWED = 403;


    public static String logErrorMessage(int code) {
        String errorMessage = "";

        switch (code) {

            case REQUEST_CANCEL:
                errorMessage = "Request Canceled";
                break;

            case INTERNET_NOT_AVAILABLE:
                errorMessage = "Internet connection is not available. Please check it and try again";
                break;

            case WRONG_URL:
                errorMessage = "You are trying to hit wrong url, Please check it and try again";
                break;

            case WRONG_METHOD_NAME:
                errorMessage = "You are passing wrong method name. i.e POST, GET, DELETE etc";

                break;

            case URL_CONNECTION_ERROR:
                errorMessage = "Connection is not established, Please try again";
                break;


            case RESPONSE_JSON_NOT_VALID:

                errorMessage = "Json you are getting is not valid";

                break;

            case MODEL_TYPE_CAST_EXCEPTION:
                errorMessage = "Server is not working. Please try after some time.";
                break;

            case NOT_ALLOWED:
                errorMessage = "Server is not working. Please try after some time.";
                break;

            default:
                errorMessage = "Unknown error";
                break;


        }
        return errorMessage;
    }
}

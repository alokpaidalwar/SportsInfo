package com.sdirect.sports.network;


public interface ServiceListener<T> {
    void getServerResponse(T response, int requestcode);

    void getError(ErrorModel error, int requestcode);
}
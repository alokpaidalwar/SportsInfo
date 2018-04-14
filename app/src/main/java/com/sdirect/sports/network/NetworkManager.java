package com.sdirect.sports.network;

import android.net.ParseException;
import android.util.Log;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.HttpException;


public class NetworkManager {
    public static final String TAG = NetworkManager.class.getSimpleName();
    protected Disposable compositeDisposable;

    public <V> void createApiRequest(Observable<V> observables, final ServiceListener callBack) {
        compositeDisposable = (observables
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<V>() {
                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull V s) {
                        callBack.getServerResponse((V) s, 0);
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        callBack.getError(setUpErrors(e), 0);
                    }

                    @Override
                    public void onComplete() {
                    }
                }));
    }


    // Handling Java Exceptions
    private ErrorModel setUpErrors(Throwable t) {
        Log.e(TAG, "setUpError statusCode: " + "statusCode " + t.getMessage());
        ErrorModel errorModel = new ErrorModel();
        try {
            // Exception comes by Java
            if (t instanceof SocketTimeoutException) {
                errorModel.error_code = ResponseCodes.INTERNET_NOT_AVAILABLE;
                errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
            } else if (t instanceof TimeoutException) {
                errorModel.error_code = ResponseCodes.URL_CONNECTION_ERROR;
                errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
            } else if (t instanceof ClassCastException) {
                errorModel.error_code = ResponseCodes.MODEL_TYPE_CAST_EXCEPTION;
                errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
            } else if (t instanceof com.google.gson.stream.MalformedJsonException) {
                errorModel.error_code = ResponseCodes.MODEL_TYPE_CAST_EXCEPTION;
                errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
            } else if (t instanceof ParseException) {
                errorModel.error_code = ResponseCodes.MODEL_TYPE_CAST_EXCEPTION;
                errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
            } else if (t instanceof UnknownHostException) {
                errorModel.error_code = ResponseCodes.INTERNET_NOT_AVAILABLE;
                errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
            } else {
                String errorMessage = ((HttpException) t).response().errorBody().string();
                int responseCode = ((HttpException) t).response().code();
                errorModel.error_code = responseCode;
                errorModel.error_message = errorMessage;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            errorModel.error_code = ResponseCodes.UNKNOWN_ERROR;
            errorModel.error_message = ResponseCodes.logErrorMessage(errorModel.error_code);
        }
        return errorModel;
    }

}
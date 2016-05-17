package com.example.juan.Trendy.data.cloud.util;

import com.example.juan.Trendy.data.factory.AuthenticationFactory;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

import javax.inject.Inject;

/**
 * @author by Juan on 5/16/16.
 */
public class AuthInterceptor implements Interceptor {
    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";
    private AuthenticationFactory authService;

    @Inject
    public AuthInterceptor(AuthenticationFactory authenticationFactory) {
        this.authService = authenticationFactory;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

//        String bearerToken = BEARER+authService.getAccessToken();
//        Request request = chain.request();
//
//        //Add bearer token to the call
//        if(!request.urlString().contains("settings")) {
//            request = request.newBuilder()
//                    .addHeader(AUTHORIZATION, bearerToken)
//                    .build();
//        }
//
//        Response response = chain.proceed(request);
//
//        //when call has expired token
//        if(response.code() == HttpURLConnection.HTTP_UNAUTHORIZED){
//            //call refresh token to renew expired token
//            Call<BaseResponse<AuthContent>> call = authService.refreshToken();
//            retrofit.Response<BaseResponse<AuthContent>> refreshedResponse = call.execute();
//
//            //on success save token
//            authService.saveAuthInfo(refreshedResponse.body().get());
//            String updatedToken = refreshedResponse.body().get().getAccessToken();
//
//            //build again initial request with renewed bearer token as header
//            Request newRequest = request.newBuilder()
//                                        .removeHeader(AUTHORIZATION)
//                                        .addHeader(AUTHORIZATION, BEARER+updatedToken)
//                                        .build();
//            //retry call with renewed token
//            response = chain.proceed(newRequest);
//        }
//
//        return response;
        return chain.proceed(chain.request());
    }

}
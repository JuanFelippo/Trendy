package com.example.juan.Trendy.data.factory;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.juan.Trendy.data.Authentication;
import com.example.juan.Trendy.data.cloud.DribbleApi;

import javax.inject.Inject;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * @author by Juan on 5/16/16.
 */
public class AuthenticationFactory implements Authentication {

    private static final String GRANT_TYPE_PASSWORD = "password";
    private static final String GRANT_TYPE_FACEBOOK = "facebook";
    private static final String GRANT_TYPE_REFRESH  = "refresh_token";
    private static final String GRANT_TYPE_GOOGLE   = "google";
    private static final String GRANT_TYPE_SIGNUP   = "signup";

    private static final String AUTH_KEY_REGID            = "REG_ID";
    private static final String AUTH_KEY_TOKEN            = "ACCESS_TOKEN";
    private static final String AUTH_KEY_REFRESH_TOKEN    = "REFRESH_TOKEN";
    private static final String AUTH_KEY_DEVICEID         = "DEVICE_ID";
    private static final String AUTH_KEY_IS_LOGGEDIN      = "LOGGED_IN";

    private DribbleApi mDribbleApi;
    private SharedPreferences sharedPreferences;
    private Context context;

    private String  regID;

    @Inject
    public AuthenticationFactory(DribbleApi mDribbleApi,Context context,SharedPreferences sharedPreferences) {
        this.context = context;
        this.mDribbleApi = mDribbleApi;
        this.sharedPreferences = sharedPreferences;
    }
//
//    //region Public Methods
//    @Override
//    public Observable<AuthContent> signinWithPassword(String userName, String password) {
//
//        return mDribbleApi.signInEmail(GRANT_TYPE_PASSWORD, getDeviceID(), userName, password)
//                .flatMap(baseResponse -> {
//
//                    try {
//                        //status not ok, parse and throw custom exception
//                        if (baseResponse.getMessage().getError())
//                            return Observable.error(new CloudException(baseResponse.getMessage().getText()));
//
//                        AuthContent content = baseResponse.get();
//                        this.saveAuthInfo(content);
//                        return Observable.just(content);
//
//                    } catch (Throwable t) {
//                        return Observable.error(t);
//                    }
//                });
//    }
//
//    @Override
//    public Observable<AuthContent> signinSocial(String grantType, String email, String socialToken) {
//
//        return mGagApi.signInSocial(grantType, getDeviceID(), email, socialToken).flatMap(baseResponse -> {
//
//            try {
//                //status not ok, parse and throw custom exception
//                if (baseResponse.getMessage().getError())
//                    return Observable.error(new CloudException(baseResponse.getMessage().getText()));
//
//                AuthContent content = baseResponse.get();
//                this.saveAuthInfo(content);
//                return Observable.just(content);
//
//            } catch (Throwable t) {
//                return Observable.error(t);
//            }
//        });
//    }
//
//    @Override
//    public Observable<AuthContent> signup(String grantType, String userName, String accessToken, String password, int gender, String email, int bday, int bmonth, int byear) {
//
//        return mGagApi.signup(grantType,getDeviceID(),userName,accessToken,password,gender,email,bday,bmonth,byear).flatMap(baseResponse -> {
//
//            try {
//                //status not ok, parse and throw custom exception
//                if (baseResponse.getMessage().getError())
//                    return Observable.error(new CloudException(baseResponse.getMessage().getText()));
//
//                AuthContent content = baseResponse.get();
//                this.saveAuthInfo(content);
//                return Observable.just(content);
//
//            } catch (Throwable t) {
//                return Observable.error(t);
//            }
//        });
//
//
//
//    }
//
//    @Override
//    public Observable<AuthContent> signinWithSocialNet(SocialNet socialNet, String socialToken) {
//        return null;
//    }
//
//    @Override
//    public Observable<AuthContent> signupPassword(String password, String userName, String gender, String email, String bday, String bmonth, String byear) {
//        return null;
//    }
//
//    @Override
//    public Call<BaseResponse<AuthContent>> refreshToken() {
//        return  mGagApi.refreshToken(getRefreshToken(),GRANT_TYPE_REFRESH,getDeviceID());
//        //return mGagApi.refreshToken(getRefreshToken(),GRANT_TYPE_REFRESH,getDeviceID())
//           /*     .flatMap(baseResponse -> {
//                    try {
//                        //status not ok, parse and throw custom exception
//                        if (baseResponse.getMessage().getError())
//                            return Observable.error(new CloudException(baseResponse.getMessage().getText()));
//
//                        AuthContent content = baseResponse.get();
//                        this.saveAuthInfo(content);
//                        return Observable.just(content);
//
//                    } catch (Throwable t) {
//                        return Observable.error(t);
//                    }
//                });*/
//    }
//
//    public void obtainGCMRegID() {
//
//        if(!getRegID().isEmpty())
//            return;
//        Observable.defer(() -> Observable.just(obtainRegID()))
//                .subscribeOn(Schedulers.newThread())
//                .subscribe(new Subscriber<String>() {
//                    @Override
//                    public void onCompleted() {}
//                    @Override
//                    public void onError(Throwable e) {}
//                    @Override
//                    public void onNext(String regid) {
//                        regID = regid;
//                    }
//                } );
//    }
//
//    public void saveAuthInfo(AuthContent authContent){
//
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putString(AUTH_KEY_REGID, this.regID);
//        editor.putBoolean(AUTH_KEY_IS_LOGGEDIN, true);
//        editor.putString(AUTH_KEY_TOKEN, authContent.getAccessToken());
//        editor.putString(AUTH_KEY_REFRESH_TOKEN,authContent.getRefreshToken());
//        editor.apply();
//    }
//    //endregion
//
//    //region Private Methods
//
//    private String obtainRegID(){
//        try {
//            InstanceID instanceID = InstanceID.getInstance(context);
//            String token = instanceID.getToken(context.getString(R.string.gcm_defaultSenderId),
//                    GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
//            return token;
//        }
//        catch (Exception e){
//            return "";
//        }
//    }
//
//    public void logOut(){
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply();
//    }
//    //endregion
//
//    //region Getters - Setters
//    public String getRegID() {return sharedPreferences.getString(AUTH_KEY_REGID,"");}
//    public String getAccessToken() {return sharedPreferences.getString(AUTH_KEY_TOKEN,"");}
//    public String getRefreshToken() {return sharedPreferences.getString(AUTH_KEY_REFRESH_TOKEN,"");}
//    public String getDeviceID() {return sharedPreferences.getString(AUTH_KEY_DEVICEID,"");}
//    public Boolean isLoggedIn(){return sharedPreferences.getBoolean(AUTH_KEY_IS_LOGGEDIN,false);}
//    //endregion
}

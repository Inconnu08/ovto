package application.taufiqrahman.com.ovto.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Taufiq Rahman on 20/04/18.
 * Manage and save preferences
 */

public class ListSharedPreference {

    public static class Set {
        Context context;

        public Set(Context context) {
            this.context = context;
        }

        public void setLoginStatus(boolean isLoggedIn) {
            SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            prefEditor.putBoolean("islogin", isLoggedIn).apply();
        }

        public void setUId(String id) {
            SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            prefEditor.putString("uid", id).apply();
        }

        public void setUName(String name) {
            SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            prefEditor.putString("uname", name).apply();
        }

        public void setEmail(String email) {
            SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            prefEditor.putString("email", email).apply();
        }

        public void setToken(String token) {
            SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            prefEditor.putString("token", token).apply();
        }

        public void setMobile(String mobile) {
            SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            prefEditor.putString("mobile", mobile).apply();
        }

        public void setImage(String image) {
            SharedPreferences.Editor prefEditor = PreferenceManager.getDefaultSharedPreferences(context).edit();
            prefEditor.putString("image", image).apply();
        }

    }//end Set


    public static class Get
    {
        Context context;

        public Get(Context context) {
            this.context = context;
        }


        public boolean getLoginStatus() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getBoolean("islogin", false);
        }

        public String getUId() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getString("uid", "id");
        }

        public String getUName() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getString("uname", "agent");
        }

        public String getEmail() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getString("email", "example@domain.com");
        }

        public String getToken() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getString("token", "123");
        }

        public String getMobile() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getString("mobile", "0123456789");
        }

        public String getImage() {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
            return prefs.getString("image", "http://myspare.net/public/upload/default.jpg");
        }

    }//end Get

}//end ListSharedPreference

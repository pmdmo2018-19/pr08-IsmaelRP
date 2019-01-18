package es.iessaladillo.pedrojoya.pr08.utils;

import android.content.Context;

import androidx.annotation.StringRes;

import android.widget.Toast;

public class ToastUtils {

    private ToastUtils() {
    }

    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    //  Sin uso, lo dejo por futuros cambios en la aplicación
    public static void toast(Context context, @StringRes int messageResId) {
        Toast.makeText(context, messageResId, Toast.LENGTH_SHORT).show();
    }

}
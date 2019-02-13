package bussapp_mobile.juniorsantos.example.com.bussapp_mobile.controller;

import android.content.Context;
import android.widget.Toast;

public class BaseController {

    private Context context;

    public BaseController(Context context) {
        this.context = context;
    }

    protected void alertLong(String s) {
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

    protected void alertShort(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}

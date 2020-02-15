package com.example.myapplication1;

public class config
{
    //URLs to register.php and confirm.php file
    public static final String REGISTER_URL = "http://192.168.10.6/AndroidOTP/register.php";
    public static final String CONFIRM_URL = "http://192.168.10.6/AndroidOTP/confirm.php";

    //Keys to send username, password, phone and otp
    public static final String KEY_PHONE = "phone";
    public static final String KEY_OTP = "otp";

    //JSON Tag from response from server
    public static final String TAGRESPONSE = "ErrorMessage";
}

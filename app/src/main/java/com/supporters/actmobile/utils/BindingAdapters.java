package com.supporters.actmobile.utils;
/*
    com.supporters.actmobile.utils
    Created by:  Dhananjay Jhinkwan
    Date: 30-05-2022
*/

import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.bumptech.glide.Glide;
import com.supporters.actmobile.R;
import com.supporters.actmobile.models.Country;

public class BindingAdapters {
    public static String baseImageUrl = "https://countryflagsapi.com/png/%s";
    @BindingAdapter("android:countryCode")
    public static void setCountryCode(ImageView imageView, Country country){
        if(imageView != null && country!=null) {
            Glide.with(imageView)
                    .load(String.format(baseImageUrl,country.getCode()))
                    .placeholder(R.drawable.ic_baseline_flag_24)
                    .error(R.drawable.ic_baseline_flag_24)
                    .into(imageView);
        }
    }

    @BindingAdapter("android:countryCode")
    public static void setCountryCode(ImageView imageView, String flagCode){
        if(imageView != null && flagCode!=null) {
            Glide.with(imageView)
                    .load(String.format(baseImageUrl,flagCode))
                    .placeholder(R.drawable.ic_baseline_flag_24)
                    .error(R.drawable.ic_baseline_flag_24)
                    .into(imageView);
        }
    }

    @BindingAdapter("android:countryName")
    public static void setCountryName(TextView textView, Country country){
        if(textView != null && country!=null){
            textView.setText(country.getName());
        }
    }

}

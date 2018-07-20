package com.example.rohit.demorecyclerview;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;



    public static  void glideimageview(Context mContext, String url, final ImageView mCircleImageView) {
        if (mContext != null) {

            Glide.with(mContext)
                    .load(url)
                    .error(R.drawable.ic_camera)
                    .placeholder(R.drawable.ic_camera)
                    .error(R.drawable.ic_camera)
                    .thumbnail(0.5f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .override(150, 150)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            if (e != null) {
                                e.printStackTrace();
                            }
                            return false; // important to return false so the error placeholder can be placed

                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target,
                                                       boolean isFromMemoryCache, boolean isFirstResource) {
                            mCircleImageView.setImageDrawable(resource);
                            return false;
                        }
                    })
                    .into(mCircleImageView);


        }
    }

    public static boolean CheckallPermissionS(Context ctx)
    {
        int camera = ContextCompat.checkSelfPermission(ctx, Manifest.permission.READ_EXTERNAL_STORAGE);
        int location = ContextCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION);
        int locationn = ContextCompat.checkSelfPermission(ctx, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        List<String> listPermissionsNeeded = new ArrayList<>();
        if (camera == PackageManager.PERMISSION_GRANTED) {
            return true;
        }else {
            listPermissionsNeeded.add(android.Manifest.permission.READ_EXTERNAL_STORAGE);

        }

        if (locationn == PackageManager.PERMISSION_GRANTED) {
            return true;
        }else {
            listPermissionsNeeded.add(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);

        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(((AppCompatActivity) ctx),
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);

        }
        return false;
    }

}

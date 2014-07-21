package com.aaronfleshner.usadivinghelix.web_calls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.aaronfleshner.usadivinghelix.R;
import com.aaronfleshner.usadivinghelix.Utils;
import com.android.volley.Response;
import com.android.volley.cache.DiskLruBasedCache;
import com.android.volley.cache.plus.ImageLoader;
import com.android.volley.error.VolleyError;
import com.android.volley.cache.plus.SimpleImageLoader;
import com.android.volley.misc.AsyncTask;


/**
 * Created by aaronfleshner on 7/20/14.
 */
public class VolleyUtils {

    /**
     * Image directory for all of the cached images saved by volley plus.
     */
    private static final String IMAGE_CACHE_DIR = "images";

    /**
     * Simple Image Loading with volley.
     * @param mContext
     * @param MemCacheSizePercent
     * @param MaxImageSize
     * @return
     */
    public static SimpleImageLoader createSimpleImageLoader(Context mContext, float MemCacheSizePercent, int MaxImageSize) {
        SimpleImageLoader mImageLoader;
        DiskLruBasedCache.ImageCacheParams cacheParams =
                new DiskLruBasedCache.ImageCacheParams(((FragmentActivity) mContext), IMAGE_CACHE_DIR);
        cacheParams.setMemCacheSizePercent(MemCacheSizePercent); // Set memory cache to 25% of app memory
        // The ImageFetcher takes care of loading images into our ImageView children asynchronously
        mImageLoader = new SimpleImageLoader(((FragmentActivity) mContext), R.drawable.ic_logo, cacheParams);
        mImageLoader.setMaxImageSize(Utils.pixelsToSP(mContext, MaxImageSize));
        mImageLoader.setFadeInImage(true);
        return mImageLoader;
    }

    /**
     * Gets a Blurred bitmap for the imageView suggested.
     *
     * @param view
     * @return
     */
    public static ImageLoader.ImageListener createBlurImageListener(final ImageView view) {
        return new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                BitmapDrawable bd = response.getBitmap();
                if (bd != null) {
                    ImageBlurTask blur = new ImageBlurTask() {
                        @Override
                        protected void onPostExecute(Bitmap bitmap) {
                            super.onPostExecute(bitmap);
                            view.setImageBitmap(bitmap);
                        }
                    };
                    blur.execute(bd.getBitmap());
                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
    }

    /**
     * To take the Image blurring off of the UI thread for smoother scrolling.
     */
    private static class ImageBlurTask extends AsyncTask<Bitmap, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Bitmap... params) {
            return Utils.fastBlur(params[0], 15);
        }
    }

    /**
     * Generic Error Listener
     */
    public static Response.ErrorListener createErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        };
    }

}

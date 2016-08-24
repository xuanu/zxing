package cn.zeffect.qr_zxing.util;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.MediaStore.MediaColumns;

public class DocumentUtil {
    public static String getPath4(final Context context, final Uri uri) {
        String localPath = "";
        Cursor cr = context.getContentResolver().query(uri,
                new String[]{MediaStore.Images.Media.DATA}, null,
                null, null);
        if (cr == null) {
            return "";
        }
        if (cr.moveToFirst()) {
            localPath = cr.getString(cr
                    .getColumnIndex(MediaStore.Images.Media.DATA));
        }
        cr.close();
        return localPath;
    }

    public static final Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(fileName, options);
            options.inSampleSize = Math.max(1,
                    (int) Math.ceil(Math.max((double) options.outWidth / 1024f, (double) options.outHeight / 1024f)));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(fileName, options);
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }
        return bitmap;
    }
}

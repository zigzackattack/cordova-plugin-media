package org.apache.cordova.media;

import java.io.InputStream;
import com.android.vending.expansion.zipfile.*;
import android.content.res.AssetFileDescriptor;
import android.content.Context;
import java.io.IOException;

import java.util.Log;

class ExpansionStorage {

  private static final String PROTOCOL = "expansion://";
  private ZipResourceFile store = null;

  public ExpansionStorage(Context ctx) {
    try {
      this.store = APKExpansionSupport.getAPKExpansionZipFile(ctx, 1, 0);
    } catch(IOException e) {
      Log.d("RiseMedia", e.getMessage());
      e.printStackTrace();
    }
  }

  public AssetFileDescriptor load(String file) {
    String filename = file.replace(PROTOCOL, "");
    AssetFileDescriptor fd = this.store.getAssetFileDescriptor(filename);

    return fd;
  }

  public static Boolean isExpansionFile(String file) {
    return file.startsWith(PROTOCOL);
  }

}

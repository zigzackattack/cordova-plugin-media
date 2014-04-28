package org.apache.cordova.risemedia;

import java.io.InputStream;
import com.android.vending.expansion.zipfile.*;
import android.content.res.AssetFileDescriptor;
import android.content.Context;

class ExpansionStorage {

  private static final String PROTOCOL = "expansion://";
  private ZipResourceFile store = null;

  public ExpansionStorage(Context ctx) {
    this.store = APKExpansionSupport.getAPKExpansionFiles(ctx, 1, 0);

  }

  public AssetFileDescriptor load(String file) {
    String file = file.replace(PROTOCOL, "");
    AssetFileDescriptor fd = this.store.getAssetFileDescriptor(file);

    return fd;
  }

  public static Boolean isExpansionFile(String file) {
    return file.startsWith(PROTOCOL);
  }

}

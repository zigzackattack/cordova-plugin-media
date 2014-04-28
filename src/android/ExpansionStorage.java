package org.apache.cordova.risemedia;

import java.io.InputStream;
import com.android.vending.expansion.zipfile.*;
import android.content.res.AssetFileDescriptor;

class ExpansionStorage {

  private static final String PROTOCOL = "expansion://";
  private ZipResourceFile store = null;

  public ExpansionStorage() {
    this.store = APKExpansionSupport.getAPKExpansionFile(getApplicationContext(), 1, 0);

  }

  public InputStream load(String file) {
    String file = file.replace(PROTOCOL, "");
    AssetFileDescriptor fd = this.store.getAssetFileDescriptor(file);

    return fd;
  }

  public static Boolean isExpansionFile(String file) {
    return file.startsWith(PROTOCOL);
  }

}

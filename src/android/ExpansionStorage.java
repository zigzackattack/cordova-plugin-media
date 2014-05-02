package org.apache.cordova.media;

import java.io.FileInputStream;
import com.android.vending.expansion.zipfile.*;
import android.content.res.AssetFileDescriptor;
import android.content.Context;
import java.io.IOException;

import android.util.Log;

class ExpansionStorage {

  private static final String PROTOCOL = "expansion://";
  private static final String LOG_TAG  = "RiseMedia";
  private ZipResourceFile store = null;

  public ExpansionStorage(Context ctx) {
    try {
    	Log.d(LOG_TAG, "Loading store...");
      this.store = APKExpansionSupport.getAPKExpansionZipFile(ctx, 2, 0);
      Log.d(LOG_TAG, "Loaded store");
    } catch(IOException e) {
      Log.d(LOG_TAG, e.getMessage());
      e.printStackTrace();
    }

    this.debug();
  }

  public AssetFileDescriptor load(String file) {
    String filename = file.replace(PROTOCOL, "");
    Log.d(LOG_TAG, filename);
    FileInputStream fis = this.store.getInputStream(filename); 
    if(fis != null) {
    	Log.d(LOG_TAG, "INPUT STREAM NOT NULL!");
    }
		AssetFileDescriptor fd = this.store.getAssetFileDescriptor(filename);
    Log.d(LOG_TAG, "Got file descriptor");

    return fd;
  }

  public void debug() {
		ZipResourceFile.ZipEntryRO[] zro = this.store.getAllEntries();
		for(ZipResourceFile.ZipEntryRO entry : zro) {
			Log.d(LOG_TAG, entry.getZipFileName());
		}
  }

  public static Boolean isExpansionFile(String file) {
    return file.startsWith(PROTOCOL);
  }

}

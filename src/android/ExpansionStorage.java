package org.apache.cordova.risemedia;

import java.io.InputStream;

class ExpansionStorage {

  private static final String PROTOCOL = "expansion://";

  public ExpansionStorage() {
    this.store = APKExpansionSupport.getAPKExpansionFile(getApplicationContext(), 1, 0);

  }

  public InputStream load(String file) {
    String file = file.replace(PROTOCOL, "");
    return this.store.getInputStream(file);
  }

  public Boolean isExpansionFile(String file) {
    return file.startsWith(PROTOCOL);
  }

}

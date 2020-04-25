package io.github.mrspock182.generate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublicKey extends Thread {

    private final KeyPair key;
    private final String path;

    private static final Logger LOG = Logger.getLogger(PublicKey.class.getName());

    public PublicKey(final KeyPair key, final String path) {
        this.key = key;
        this.path = path;
    }

    public void run() {
        try {
            File publicFileKey = new File(path);

            if (!publicFileKey.exists()) {
                if (publicFileKey.getParentFile() != null) {
                    publicFileKey.getParentFile().mkdirs();
                }

                if (publicFileKey.createNewFile()) {
                    try (ObjectOutputStream publicOutputStream = new ObjectOutputStream(new FileOutputStream(publicFileKey))) {
                        publicOutputStream.writeObject(key.getPublic());
                    }
                }
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.toString(), ex);
        }
    }

}

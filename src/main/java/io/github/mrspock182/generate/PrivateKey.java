package io.github.mrspock182.generate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrivateKey extends Thread {

    private final KeyPair key;
    private final String path;

    private static final Logger LOG = Logger.getLogger(PrivateKey.class.getName());

    public PrivateKey(final KeyPair key, final String path) {
        this.key = key;
        this.path = path;
    }

    public void run() {
        try {
            File privateFileKey = new File(path);

            if (!privateFileKey.exists()) {
                if (privateFileKey.getParentFile() != null) {
                    privateFileKey.getParentFile().mkdirs();
                }

                if (privateFileKey.createNewFile()) {
                    try (ObjectOutputStream privateOutputStream = new ObjectOutputStream(new FileOutputStream(privateFileKey))) {
                        privateOutputStream.writeObject(key.getPrivate());
                    }
                }
            }
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, ex.toString(), ex);
        }
    }

}

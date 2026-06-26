package com.example.crudapp.legacy;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * This class uses SecurityManager which is deprecated in Java 17
 * and removed for removal in Java 21+
 */
public class SecurityManagerExample {
    
    @SuppressWarnings("removal")
    public void checkFileAccess(String filename) {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(filename);
        }
    }
    
    @SuppressWarnings("removal")
    public String executePrivilegedAction() {
        return AccessController.doPrivileged(new PrivilegedAction<String>() {
            @Override
            public String run() {
                return System.getProperty("user.home");
            }
        });
    }
    
    @SuppressWarnings("removal")
    public void setSecurityManager() {
        System.setSecurityManager(new SecurityManager());
    }
}

// Made with Bob

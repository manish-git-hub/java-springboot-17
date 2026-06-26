package com.example.crudapp.legacy;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * This class uses finalize() method which is deprecated in Java 9
 * and removed in Java 18+. This will cause compilation errors in Java 21.
 */
public class FinalizeExample {
    
    private FileInputStream fileStream;
    private String resourceName;
    
    public FinalizeExample(String filename) throws IOException {
        this.fileStream = new FileInputStream(filename);
        this.resourceName = filename;
    }
    
    // finalize() is deprecated and will be removed
    @Override
    @SuppressWarnings("deprecation")
    protected void finalize() throws Throwable {
        try {
            if (fileStream != null) {
                fileStream.close();
                System.out.println("Finalized: " + resourceName);
            }
        } finally {
            super.finalize();
        }
    }
    
    public void readData() throws IOException {
        if (fileStream != null) {
            byte[] buffer = new byte[1024];
            fileStream.read(buffer);
        }
    }
    
    // Another class with finalize
    public static class ResourceHolder {
        private Object resource;
        
        public ResourceHolder(Object resource) {
            this.resource = resource;
        }
        
        @Override
        @SuppressWarnings("deprecation")
        protected void finalize() throws Throwable {
            try {
                cleanup();
            } finally {
                super.finalize();
            }
        }
        
        private void cleanup() {
            System.out.println("Cleaning up resource: " + resource);
            resource = null;
        }
    }
    
    // Complex finalize with multiple resources
    public static class ComplexResource {
        private FileInputStream stream1;
        private FileInputStream stream2;
        
        public ComplexResource(String file1, String file2) throws IOException {
            this.stream1 = new FileInputStream(file1);
            this.stream2 = new FileInputStream(file2);
        }
        
        @Override
        @SuppressWarnings("deprecation")
        protected void finalize() throws Throwable {
            try {
                if (stream1 != null) stream1.close();
                if (stream2 != null) stream2.close();
            } finally {
                super.finalize();
            }
        }
    }
}

// Made with Bob

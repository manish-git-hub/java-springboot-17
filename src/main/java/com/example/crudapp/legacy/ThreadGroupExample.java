package com.example.crudapp.legacy;

/**
 * This class uses ThreadGroup methods that are deprecated in Java 17
 * and should be migrated to modern concurrency utilities in Java 21
 */
public class ThreadGroupExample {
    
    private ThreadGroup threadGroup;
    
    public ThreadGroupExample(String name) {
        this.threadGroup = new ThreadGroup(name);
    }
    
    @SuppressWarnings("deprecation")
    public void stopAllThreads() {
        // Thread.stop() is deprecated and dangerous
        threadGroup.stop();
    }
    
    @SuppressWarnings("deprecation")
    public void suspendAllThreads() {
        // Thread.suspend() is deprecated
        threadGroup.suspend();
    }
    
    @SuppressWarnings("deprecation")
    public void resumeAllThreads() {
        // Thread.resume() is deprecated
        threadGroup.resume();
    }
    
    @SuppressWarnings("deprecation")
    public int countThreads() {
        return threadGroup.activeCount();
    }
    
    @SuppressWarnings("deprecation")
    public void destroyGroup() {
        // ThreadGroup.destroy() is deprecated
        threadGroup.destroy();
    }
    
    // Using deprecated Thread constructor
    @SuppressWarnings("deprecation")
    public Thread createThread(Runnable task, String name) {
        return new Thread(threadGroup, task, name);
    }
}

// Made with Bob

package com.example.crudapp.legacy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * This class uses reflection patterns that may have issues in Java 21
 * due to stronger encapsulation and module system restrictions
 */
public class ReflectionExample {
    
    // Accessing private fields without proper module opens
    public Object getPrivateField(Object obj, String fieldName) throws Exception {
        var field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true); // This may fail in Java 21 with strong encapsulation
        return field.get(obj);
    }
    
    // Setting private fields
    public void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        var field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
    
    // Invoking private methods
    public Object invokePrivateMethod(Object obj, String methodName, Class<?>[] paramTypes, Object[] args) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, paramTypes);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }
    
    // Creating instances via reflection without proper access
    @SuppressWarnings("deprecation")
    public <T> T createInstance(Class<T> clazz) throws Exception {
        // Using deprecated newInstance()
        return clazz.newInstance();
    }
    
    // Accessing private constructors
    public <T> T createInstanceWithPrivateConstructor(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }
    
    // Deep reflection that breaks encapsulation
    public void modifyFinalField(Object obj, String fieldName, Object newValue) throws Exception {
        var field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        
        // Removing final modifier (highly problematic in modern Java)
        var modifiersField = java.lang.reflect.Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~java.lang.reflect.Modifier.FINAL);
        
        field.set(obj, newValue);
    }
    
    // Accessing internal JDK classes (will fail in Java 21)
    public Object accessInternalClass() throws Exception {
        Class<?> unsafeClass = Class.forName("sun.misc.Unsafe");
        var field = unsafeClass.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return field.get(null);
    }
}

// Made with Bob

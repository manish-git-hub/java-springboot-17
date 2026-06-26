package com.example.crudapp.legacy;

import java.util.Vector;
import java.util.Stack;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * This class uses legacy collection classes (Vector, Stack, Hashtable)
 * that should be migrated to modern alternatives
 */
public class VectorStackExample {
    
    // Vector is synchronized but slower than ArrayList
    private Vector<String> dataVector = new Vector<>();
    
    // Stack extends Vector and is also legacy
    private Stack<Integer> numberStack = new Stack<>();
    
    // Hashtable is synchronized but slower than HashMap
    private Hashtable<String, Object> configTable = new Hashtable<>();
    
    public void addToVector(String item) {
        dataVector.addElement(item); // Legacy method
    }
    
    public void removeFromVector(String item) {
        dataVector.removeElement(item); // Legacy method
    }
    
    public String getVectorElement(int index) {
        return dataVector.elementAt(index); // Legacy method
    }
    
    public void setVectorElement(int index, String value) {
        dataVector.setElementAt(value, index); // Legacy method
    }
    
    // Using Enumeration instead of Iterator
    public void printVector() {
        Enumeration<String> enumeration = dataVector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
    
    // Stack operations
    public void pushToStack(Integer value) {
        numberStack.push(value);
    }
    
    public Integer popFromStack() {
        return numberStack.pop();
    }
    
    public Integer peekStack() {
        return numberStack.peek();
    }
    
    public boolean isStackEmpty() {
        return numberStack.empty(); // Legacy method name
    }
    
    public int searchStack(Integer value) {
        return numberStack.search(value); // Returns 1-based position
    }
    
    // Hashtable operations
    public void putInTable(String key, Object value) {
        configTable.put(key, value);
    }
    
    public Object getFromTable(String key) {
        return configTable.get(key);
    }
    
    // Using Enumeration with Hashtable
    public void printTableKeys() {
        Enumeration<String> keys = configTable.keys();
        while (keys.hasMoreElements()) {
            System.out.println(keys.nextElement());
        }
    }
    
    public void printTableValues() {
        Enumeration<Object> values = configTable.elements();
        while (values.hasMoreElements()) {
            System.out.println(values.nextElement());
        }
    }
    
    // Complex nested legacy collections
    private Vector<Hashtable<String, Stack<Integer>>> complexStructure = new Vector<>();
    
    public void addComplexData(Hashtable<String, Stack<Integer>> data) {
        complexStructure.addElement(data);
    }
    
    public Stack<Integer> getNestedStack(int vectorIndex, String key) {
        return complexStructure.elementAt(vectorIndex).get(key);
    }
    
    // Synchronized block with Vector (redundant since Vector is already synchronized)
    public synchronized void synchronizedVectorOperation() {
        synchronized (dataVector) {
            for (int i = 0; i < dataVector.size(); i++) {
                String element = dataVector.elementAt(i);
                // Process element
                System.out.println(element);
            }
        }
    }
}

// Made with Bob

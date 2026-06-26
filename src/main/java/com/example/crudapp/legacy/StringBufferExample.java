package com.example.crudapp.legacy;

/**
 * This class demonstrates StringBuffer usage patterns that should be
 * migrated to StringBuilder for better performance in single-threaded contexts
 */
public class StringBufferExample {
    
    // StringBuffer is synchronized, StringBuilder is not (and faster)
    private StringBuffer buffer = new StringBuffer();
    
    public String buildQuery(String table, String[] columns, String condition) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT ");
        
        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i]);
            if (i < columns.length - 1) {
                query.append(", ");
            }
        }
        
        query.append(" FROM ");
        query.append(table);
        
        if (condition != null && !condition.isEmpty()) {
            query.append(" WHERE ");
            query.append(condition);
        }
        
        return query.toString();
    }
    
    public String concatenateStrings(String... strings) {
        StringBuffer result = new StringBuffer();
        for (String str : strings) {
            result.append(str);
            result.append(" ");
        }
        return result.toString().trim();
    }
    
    // Unnecessary synchronization overhead
    public synchronized String buildPath(String... parts) {
        StringBuffer path = new StringBuffer();
        for (int i = 0; i < parts.length; i++) {
            path.append(parts[i]);
            if (i < parts.length - 1) {
                path.append("/");
            }
        }
        return path.toString();
    }
    
    // Complex string building with StringBuffer
    public String generateReport(String title, String[] data) {
        StringBuffer report = new StringBuffer();
        report.append("=".repeat(50));
        report.append("\n");
        report.append(title.toUpperCase());
        report.append("\n");
        report.append("=".repeat(50));
        report.append("\n\n");
        
        for (int i = 0; i < data.length; i++) {
            report.append(i + 1);
            report.append(". ");
            report.append(data[i]);
            report.append("\n");
        }
        
        report.append("\n");
        report.append("Total items: ");
        report.append(data.length);
        
        return report.toString();
    }
    
    // Nested StringBuffer usage
    public String buildNestedStructure(String[][] matrix) {
        StringBuffer outer = new StringBuffer();
        outer.append("[\n");
        
        for (int i = 0; i < matrix.length; i++) {
            StringBuffer inner = new StringBuffer();
            inner.append("  [");
            
            for (int j = 0; j < matrix[i].length; j++) {
                inner.append(matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    inner.append(", ");
                }
            }
            
            inner.append("]");
            outer.append(inner.toString());
            
            if (i < matrix.length - 1) {
                outer.append(",\n");
            }
        }
        
        outer.append("\n]");
        return outer.toString();
    }
    
    // Instance variable StringBuffer (thread-safe but slower)
    public void appendToBuffer(String text) {
        buffer.append(text);
        buffer.append("\n");
    }
    
    public String getBufferContent() {
        return buffer.toString();
    }
    
    public void clearBuffer() {
        buffer.setLength(0);
    }
}

// Made with Bob

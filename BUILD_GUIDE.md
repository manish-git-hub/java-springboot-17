# Building the Application in VSCode

This guide explains how to build and run the Java Spring Boot 17 application in Visual Studio Code.

## Prerequisites

### 1. Install Java Development Kit (JDK)
- **Java 17** (for running the legacy code)
- Download from: https://adoptium.net/ or https://www.oracle.com/java/technologies/downloads/

Verify installation:
```bash
java -version
```

### 2. Install Visual Studio Code
- Download from: https://code.visualstudio.com/

### 3. Install Required VSCode Extensions

Open VSCode and install these extensions:

1. **Extension Pack for Java** (by Microsoft)
   - Includes: Language Support, Debugger, Test Runner, Maven, Project Manager
   - Extension ID: `vscjava.vscode-java-pack`

2. **Spring Boot Extension Pack** (by VMware)
   - Includes: Spring Boot Tools, Spring Initializr, Spring Boot Dashboard
   - Extension ID: `vmware.vscode-boot-dev-pack`

**To install extensions:**
- Press `Ctrl+Shift+X` (Windows/Linux) or `Cmd+Shift+X` (Mac)
- Search for the extension name
- Click "Install"

## Building the Application

### Method 1: Using VSCode Terminal

1. **Open the project in VSCode:**
   ```bash
   code .
   ```
   Or: File → Open Folder → Select the project directory

2. **Open integrated terminal:**
   - Press `` Ctrl+` `` (backtick) or
   - View → Terminal

3. **Build the project:**
   ```bash
   # Windows
   .\mvnw.cmd clean package
   
   # Linux/Mac
   ./mvnw clean package
   ```

4. **Run the application:**
   ```bash
   # Windows
   .\mvnw.cmd spring-boot:run
   
   # Linux/Mac
   ./mvnw spring-boot:run
   ```

### Method 2: Using Maven Extension

1. **Open Maven sidebar:**
   - Click the Maven icon in the left sidebar (looks like an "M")
   - Or press `Ctrl+Shift+P` and type "Maven: Show Maven Projects"

2. **Expand your project:**
   - Find `crud-app` or your project name
   - Expand the tree

3. **Build:**
   - Expand "Lifecycle"
   - Right-click on `clean` → Run
   - Right-click on `package` → Run

4. **Run:**
   - Expand "Plugins" → "spring-boot"
   - Right-click on `spring-boot:run` → Run

### Method 3: Using Spring Boot Dashboard

1. **Open Spring Boot Dashboard:**
   - Click the Spring Boot icon in the left sidebar
   - Or View → Open View → Spring Boot Dashboard

2. **Run the application:**
   - Find your application in the list
   - Click the play button (▶) next to it

3. **Stop the application:**
   - Click the stop button (■) next to the running app

## Running with Specific Java Version

If you have multiple Java versions installed:

### Windows (PowerShell):
```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
.\mvnw.cmd spring-boot:run
```

### Windows (Command Prompt):
```cmd
set JAVA_HOME=C:\Program Files\Java\jdk-17
.\mvnw.cmd spring-boot:run
```

### Linux/Mac:
```bash
export JAVA_HOME=/path/to/jdk-17
./mvnw spring-boot:run
```

## Debugging the Application

1. **Set breakpoints:**
   - Click in the left margin of any Java file (red dot appears)

2. **Start debugging:**
   - Press `F5` or
   - Run → Start Debugging or
   - Click the debug icon in Spring Boot Dashboard

3. **Debug controls:**
   - `F5` - Continue
   - `F10` - Step Over
   - `F11` - Step Into
   - `Shift+F11` - Step Out
   - `Shift+F5` - Stop

## Testing the Application

### Access the Application:
- **Main URL:** http://localhost:8080
- **H2 Console:** http://localhost:8080/h2-console
- **API Base:** http://localhost:8080/api/users

### Using VSCode REST Client Extension:

1. **Install REST Client extension:**
   - Extension ID: `humao.rest-client`

2. **Create a test file** `test.http`:
   ```http
   ### Create User
   POST http://localhost:8080/api/users
   Content-Type: application/json

   {
     "name": "John Doe",
     "email": "john@example.com",
     "phone": "1234567890",
     "address": "123 Main St"
   }

   ### Get All Users
   GET http://localhost:8080/api/users

   ### Get User by ID
   GET http://localhost:8080/api/users/1

   ### Update User
   PUT http://localhost:8080/api/users/1
   Content-Type: application/json

   {
     "name": "John Updated",
     "email": "john.updated@example.com",
     "phone": "0987654321",
     "address": "456 Oak Ave"
   }

   ### Delete User
   DELETE http://localhost:8080/api/users/1
   ```

3. **Click "Send Request"** above each request

## Common Issues and Solutions

### Issue 1: "JAVA_HOME not set"
**Solution:**
- Set JAVA_HOME environment variable
- Or use the commands shown in "Running with Specific Java Version"

### Issue 2: "Port 8080 already in use"
**Solution:**
- Stop other applications using port 8080
- Or change port in `application.properties`:
  ```properties
  server.port=8081
  ```

### Issue 3: Maven wrapper not executable
**Solution (Linux/Mac):**
```bash
chmod +x mvnw
```

### Issue 4: Extension not recognizing Java project
**Solution:**
- Press `Ctrl+Shift+P`
- Type "Java: Clean Java Language Server Workspace"
- Restart VSCode

### Issue 5: Build fails with compilation errors
**Solution:**
- Ensure you're using Java 17 (not Java 21)
- The legacy code is designed for Java 17
- Check JAVA_HOME points to JDK 17

## VSCode Settings for Java

Create or update `.vscode/settings.json`:

```json
{
  "java.configuration.runtimes": [
    {
      "name": "JavaSE-17",
      "path": "C:\\Program Files\\Java\\jdk-17",
      "default": true
    }
  ],
  "java.compile.nullAnalysis.mode": "automatic",
  "spring-boot.ls.java.home": "C:\\Program Files\\Java\\jdk-17"
}
```

## Useful VSCode Shortcuts

- `Ctrl+Shift+P` - Command Palette
- `Ctrl+P` - Quick Open File
- `Ctrl+Shift+F` - Search in Files
- `Ctrl+B` - Toggle Sidebar
- `` Ctrl+` `` - Toggle Terminal
- `F5` - Start Debugging
- `Ctrl+F5` - Run Without Debugging
- `Shift+Alt+F` - Format Document

## Project Structure in VSCode

```
java-spring-boot-17/
├── .vscode/              # VSCode settings
├── src/
│   └── main/
│       ├── java/         # Java source files
│       └── resources/    # Configuration files
├── target/               # Compiled files (generated)
├── pom.xml              # Maven configuration
├── mvnw.cmd             # Maven wrapper (Windows)
├── mvnw                 # Maven wrapper (Linux/Mac)
└── README.md            # Documentation
```

## Next Steps

1. Build and run the application
2. Test the API endpoints
3. Review the legacy code in `src/main/java/com/example/crudapp/legacy/`
4. Read [MIGRATION_GUIDE.md](MIGRATION_GUIDE.md) for migration information
5. Start developing your migration agent!

## Additional Resources

- [VSCode Java Documentation](https://code.visualstudio.com/docs/java/java-tutorial)
- [Spring Boot in VSCode](https://code.visualstudio.com/docs/java/java-spring-boot)
- [Maven in VSCode](https://code.visualstudio.com/docs/java/java-build)
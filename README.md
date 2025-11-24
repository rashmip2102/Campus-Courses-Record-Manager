# Campus-Courses-Record-Manager
About Campus Course and Records Manager is a Java SE console application that manages students, courses, enrollments, and grades. It supports CRUD operations, GPA computation, transcript generation, and file import/export. Designed with OOP principles and modern Java features.
# Campus Course Records Manager

## Evolution of Java

- 1995: Java 1.0 released by Sun Microsystems.
- 1998: Java 2 introduced Java SE, EE, and ME editions.
- 2006: Sun releases Java under GPL, Oracle acquires Sun.
- 2011: Java SE 7 released with new language features.
- 2014: Java SE 8 introduces lambdas and streams.
- 2017: Java SE 9 with modular system.
- 2024: Latest versions include up to Java SE 24 with many enhancements.

## Java Editions: ME vs SE vs EE

| Edition      | Description                        | Use Case                        |
|--------------|------------------------------------|---------------------------------|
| Java ME      | Micro Edition for embedded systems | Mobile phones, IoT devices      |
| Java SE      | Standard Edition for desktop/server| Desktop applications, utilities |
| Java EE      | Enterprise Edition for large apps  | Web/Enterprise servers, services|

## Java Architecture: JDK, JRE, JVM

- **JDK (Java Development Kit):**  
  Full development kit including compiler (javac), libraries, and tools.

- **JRE (Java Runtime Environment):**  
  Includes JVM and core libraries to run Java applications but no development tools.

- **JVM (Java Virtual Machine):**  
  Executes Java bytecode on a given platform providing portability.

### Interaction:  
Developers write code → JDK compiles code → JVM runs compiled bytecode with JRE supporting runtime.

## Installing and Configuring Java on Windows

1. Download the latest Java JDK from [Oracle/OpenJDK site].
2. Run the installer and follow instructions.
3. Set environment variables:
   - Add `JAVA_HOME` pointing to JDK installation directory.
   - Append `%JAVA_HOME%\bin` to the `Path` variable.

## Using Eclipse IDE: New Project Creation and Run Configurations

1. Open Eclipse IDE.
2. File → New → Java Project.
3. Enter project name, uncheck “Use default location” to select desired workspace.
4. Choose “Create separate folders for sources and class files”.
5. Click Finish.


### Running the project

- Right-click the main class → Run As → Java Application.
- Configure run configurations for specific arguments or settings via Run → Run Configurations.

---

1. Clone or Open the Project
   Repository Link: https://github.com/rashmip2102/Campus-Courses-Record-Manager
   Open the project in your IDE.

2. Place CSV Files
Ensure the CSV files are available at:  
`data/students.csv`  
`data/courses.csv`  
`data/enrollments.csv`

3. Build the Project
Compile the Java source files in your IDE or use build tools like Maven/Gradle if configured.

4. Run the Application
Run the main class `edu.ccrm.cli.CCRMApp`. The application loads data from the CSV 

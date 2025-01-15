# 🛠️ JSON and XML Validator

This program validates JSON files (and optionally XML files) in a specified folder and its subfolders. It provides the ability to display only invalid files by default or all files if specified.

---

## ✨ Features
- ✅ Validate JSON files by default.
- 📂 Optionally validate XML files using the `-xml` flag.
- 📜 Display only invalid files or all files using the `-all` flag.
- 💬 Helpful error messages for invalid files.

---

## 📝 Prerequisites
- [Java 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html)
- [Gradle](https://gradle.org/) (optional if you want to build manually)

---

## ⚙️ Build Instructions
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-directory>
   ```

2. Build the project using Gradle:
   ```bash
   ./gradlew clean build
   ```

3. The JAR file will be generated in the `build/libs` directory:
   ```bash
   build/libs/json-checker-1.0.jar
   ```

---

## 🚀 Usage

### Running the Program
To run the program, use the following command:
```bash
java -jar build/libs/json-checker-1.0.jar <path-to-folder> [options]
```

### Options
- **`-xml`**: Validate XML files in addition to JSON files.
- **`-all`**: Output both valid and invalid files.
- **`-help`**: Display help information.

### Examples
1. **Validate only JSON files in a folder:**
   ```bash
   java -jar build/libs/json-checker-1.0.jar /path/to/folder
   ```

2. **Validate both JSON and XML files:**
   ```bash
   java -jar build/libs/json-checker-1.0.jar /path/to/folder -xml
   ```

3. **Output both valid and invalid files:**
   ```bash
   java -jar build/libs/json-checker-1.0.jar /path/to/folder -all
   ```

4. **Show help message:**
   ```bash
   java -jar build/libs/json-checker-1.0.jar -help
   ```

---

## ⚠️ Error Reporting
For each invalid file, the program will display the file name and an error message describing the problem.

---

## 📜 License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

🌟 **Thank you for using the JSON and XML Validator!** 🌟


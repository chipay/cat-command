# Cat Commands
Cat command shell providing wrapping calls to some cute rest cat API

# Requirements
Maven 3

## Package

```bash
mvn package
```

## Run Tests

```bash
mvn test
```

## Run Cat command shell
After the cat command shell app has been packaged you can run it:

```bash
java -jar target/cat-command-1.0-RELEASE.jar
```

## Commands

### Facts
```bash
cat fact
```
Gets a cat fact

### File
```bash
cat file --path <path_to_save_file>
```
Gets a cat image and saves it to the specified path. The image URL is displayed in the console.
This command has an issue with the Jackson mapping (see Issue tracker).

### Categories
TODO
```bash
cat categories
```


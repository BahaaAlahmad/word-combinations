# Word Combinations

A Java application that finds all combinations of two or more words
that form a six-character word. Both the individual words and the
resulting word must exist in `input.txt`.

## Requirements

- JDK 21 or newer
- Maven 3.9 or newer
- Internet access on the first run to download Maven dependencies

## How to Run

Clone the repository and open a terminal in the project root
(the folder containing `pom.xml` and `input.txt`).

Compile and run the application with one command:

```bash
mvn compile org.codehaus.mojo:exec-maven-plugin:3.5.0:java "-Dexec.mainClass=com.example.Main"
```

Results are printed to the terminal.

## Input and Output

Place one word per line in `input.txt`.

Example input:

```text
foobar
fo
obar
foo
bar
```

Output:

```text
fo+obar=foobar
foo+bar=foobar
```

## How It Works

The application reads the input into a set, then examines each
six-character word. It uses recursive backtracking to find every
way to split that word into smaller words present in the input.

- Supports combinations of two or more words.
- Ignores blank lines and duplicate words.
- Matching is case-sensitive.
- A word can be reused within a combination.

## Changing the Target Length

Change the `TARGET_LENGTH` constant in `Main.java`.
The default value is `6`.
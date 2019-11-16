# Multi-module compilation

It is possible to compile multiple modules with the same commands.

Create the mods directory to hold the modules.

```bash
mkdir mods
```

Compile the source for multiple modules. See <https://docs.oracle.com/javase/9/tools/javac.htm#JSWOR627>.

```bash
javac -d mods --module-source-path src $(find src -name "*.java")
```

Run the program as we would do so normally

```bash
java --module-path mods -m com.greetings/com.greetings.Main
```

Voila!

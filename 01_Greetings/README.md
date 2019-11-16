# Greetings

Create the `mods/com.greetings` directory to place the compiled module.

```bash
mkdir -p mods/com.greetings
```

Compile the source code.

```bash
javac -d mods/com.greetings src/com.greetings/module-info.java src/com.greetings/com/greetings/Main.java 
```

Run the program.

```bash
java --module-path mods -m com.greetings/com.greetings.Main
```

Parkour!

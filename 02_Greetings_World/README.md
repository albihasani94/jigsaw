# Greetings world

Update the `com.greeting` module declaration to declare a dependency on the `org.astro` module. 

This module exports the `org.astro` package.

The modules should be compiled in an order so that the dependencies can be respected.

Create the directories for modules.

```bash
mkdir -p mods/org.astro mods/com.greetings
```

Compile the `org.astro` module as this module is required by `com.greetings` at compile time.

```bash
javac -d mods/org.astro src/org.astro/module-info.java src/org.astro/org/astro/World.java
```

Compile the `com.greetings` module specifying a path to an existing modules directory

```bash
javac --module-path mods -d mods/com.greetings src/com.greetings/module-info.java src/com.greetings/com/greetings/Main.java 
```

Run our main module

```bash
java --module-path mods -m com.greetings/com.greetings.Main
```

Banzai!

## Trying to break what it works

Remove the module and have a missing module dependency at runtime.

```bash
java --module-path mods -m com.greetings/com.greetings.Main
Error occurred during initialization of boot layer
java.lang.module.FindException: Module org.astro not found, required by com.greetings
```

Sweet! With the traditional classpath way of running java applications, this would start and when the `World` class would be called boom! NoClassDefFoundError. Imagine this for a bigger application used by many clients worldwide. You would provide them with a button that when clicked then it would break the application.

Remove the module and have a missing module dependency at compile time.

```bash
javac --module-path mods -d mods/com.greetings src/com.greetings/module-info.java src/com.greetings/com/greetings/Main.java 
src/com.greetings/module-info.java:2: error: module not found: org.astro
    requires org.astro;
                ^
1 error
```

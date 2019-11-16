# Packaging

For transportation and deployment purposes it is more convenient to package our modules as modular JARs.

Create a mlib to serve as a module library

```bash
mkdir mlib
```

Create the first version of `org.astro` module. See <https://docs.oracle.com/javase/9/tools/jar.htm#JSWOR614>.

```bash
jar --create --file=mlib/org.astro@1.0.jar --module-version=1.0 -C mods/org.astro .
```

Create the `com.greetings` modular jar indicating its main class.

```bash
jar --create --file=mlib/com.greetings.jar --main-class=com.greetings.Main -C mods/com.greetings .
```

Run our module without specifying the main class. See <https://docs.oracle.com/javase/9/tools/java.htm#JSWOR624>.

```bash
java -p mlib -m com.greetings
```

Hasta la vista baby!

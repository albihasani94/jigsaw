# Modules according to Mark Reinhold

Write the main class.

## The classpath arghh!

Compile it *the usual way*.

```bash
javac -d classes src/org/openjdk/hello/Main.java
```

Package it into `jar`

```bash
mkdir lib
jar --create --file lib/hello.jar -C classes .
```

Run it *in usual fashion.*

```bash
java -classpath lib/hello.jar org.openjdk.hello.Main
```

## The modulepath

Write the module-info.java

Compile it.

```bash
javac -d classes src/module-info.java
```

Make the jar file again

```bash
jar -c -f lib/hello.jar -C classes .
```

View the contents of the jar

```bash
jar tvf lib/hello.jar
```

We got a modular jar!

Describe the modular jar.

```bash
jar --file lib/hello.jar --describe-module
org.openjdk.hello jar:file:///Users/albihasani94/Desktop/jigsaw/08_mreinhold_hello/lib/hello.jar/!module-info.class
requires java.base mandated
contains org.openjdk.hello
```

Run it in modular form

```bash
java --module-path lib -m org.openjdk.hello/org.openjdk.hello.Main
```

You can still run it on the classpath tho, using -classpath.

## And then

Insert info about the main class in the jar

```
jar -c -f lib/hello.jar --main-class org.openjdk.hello.Main -C classes .
```

Run it without needing to specify the main class

```
java --module-path lib -m org.openjdk.hello
```

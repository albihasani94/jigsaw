# Missing requires or missing exports

Now let's omit stuff and see what happens.

First create the mods directory.

```bash
mkdir mods
```

Then compile the first module.

```bash
javac -d mods/org.astro src/org.astro/module-info.java src/org.astro/org/astro/World.java
```

Comment out the line of declaring dependency on the requiring module.

```java
module com.greetings {
    // requires org.astro;
}
```

Compile the main module.

```bash
javac --module-path mods -d mods/com.greetings src/com.greetings/module-info.java src/com.greetings/com/greetings/Main.java 
src/com.greetings/com/greetings/Main.java:3: error: package org.astro is not visible
import org.astro.World;
          ^
  (package org.astro is declared in module org.astro, but module com.greetings does not read it)
1 error
```

Fix the missing declaration and introduce a missing exported package from the module that is depended upon.

```java
module org.astro {
    // exports org.astro;
}
```

Recompile both modules.

```bash
javac --module-path mods -d mods/com.greetings src/com.greetings/module-info.java src/com.greetings/com/greetings/Main.java
src/com.greetings/com/greetings/Main.java:3: error: package org.astro is not visible
import org.astro.World;
          ^
  (package org.astro is declared in module org.astro, which does not export it)
1 error
```

Kaboom!

# The linker

`jlink` is the linker tool used to link a set of modules to create a custom modular runtime image.

This tool requires the modules on the module path to be packaged in modular JAR or JMOD format.

Create a runtime image that contains the `com.greetings` module and its transitive dependencies.

```bash
jlink --module-path $JAVA_HOME/jmods:mlib --add-modules com.greetings --output custom_jre
```

$JAVA_HOME/jmods is the directory containing the `java.base` and the other standard JDK modules.

Check the size of the custom_jre

```bash
du -sh custom_jre/
37M    custom_jre/
```

Magnets biatch!

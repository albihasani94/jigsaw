# Services

Services allow for loose coupling between service consumer modules and service provider modules.

Module `com.sockets` exports an API for networks sockets. The exported API is in the `com.sockets` package.
The service type is the `com.socket.spi.NetworkSocketProvider` class and the `com.sockets.spi` package is also exported.

Module `org.fastsocket` is a service provider module. It requires the `com.sockets` module.
It provides an implementation of the `com.socket.spi.NetworkSocketProvider`.
It does not export any package.

Module `com.greetings` requires the `com.socket` interface module.
It does not have knowledge of and it does not require the implementation module.

Create the `mods` directory.

```bash
mkdir mods
```

Compile the `com.socket` and `org.fastsocket` modules.

```bash
javac -d mods --module-source-path src $(find src -name "*.java")
```

Compile the `com.greetings` module.

```bash
javac -d mods/com.greetings -p mods $(find src/com.greetings/ -name "*.java")
```

Run the main module

```bash
java -p mods -m com.greetings/com.greetings.Main
class org.fastsocket.FastNetworkSocket
```

It's morphin time!

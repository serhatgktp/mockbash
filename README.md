# mockbash
A shell implemented from scratch in Java that is meant to mimic bash.
This program maintains its own virtual file system in memory and is decoupled from the file system of the host machine, with the exception of commands `saveJShell` and `loadJShell`, which allows the user to export and import JShell sessions.

Run `JShell.java` to get started

List of available commands:

```
- rm
- exit
- mkdir
- cd
- ls
- pwd
- mv
- cp
- cat
- curl
- echo
- man
- pushd
- popd
- history
- saveJShell
- loadJShell
- search
- tree
```

You may use the 'man' command to get information about how to use each command

e.g. `/> man mkdir`

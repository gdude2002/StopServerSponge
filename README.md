StopServer
==========

This is a Sponge port of perhaps my simplest plugin, [StopServer](https://github.com/gdude2002/StopServer).
It was developed by request, to some fairly exact specifications. I decided to port it to give myself
an idea on how the Sponge API works.

Compiling
=========

To compile this plugin, you may use the Gradle wrapper. Simply `cd` into the directory you cloned into, and do..

```bash
gradlew shadowJar
```

..and your JAR should be in `build/libs`.

Testing
=======

As there isn't a proper Sponge implementation yet, I've been testing with SpaceManiac's [ShinySponge](https://github.com/GlowstoneMC/ShinySponge).
If you're lazy, you can download a build artifact [from my build server](http://bamboo.gserv.me/browse/GLOW-SPENG/latest).

Download a copy of this, create a `plugins` folder and copy the compiled JAR into it, make sure a `config` folder exists
as well, and run the ShinySponge JAR from a terminal.

```bash
java -jar ShinySponge.jar
```

This will launch ShinySponge, which will load the plugin, print a few lines of information and exit.
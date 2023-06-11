# GroovyMDK
A Groovy Mod Development Kit for Forge 1.19.4.

## Features
This template includes the following features:
- [MinecraftForge](https://files.minecraftforge.net/net/minecraftforge/forge/index_1.19.4.html) the popular compatibility layer for Minecraft mods
- [Parchment](https://parchmentmc.org/) open community-sourced parameter names and javadocs for Minecraft
- [Groovy](https://groovy-lang.org/) the Groovy programming language
- [GroovyModLoader](https://github.com/GroovyMC/GroovyModLoader) for loading Groovy Forge mods
- [mods.groovy](https://github.com/GroovyMC/ModsDotGroovy) for mod metadata
- [CommonGroovyLibrary](https://github.com/GroovyMC/CommonGroovyLibrary) a Groovy library for MC mods that's commonly available across loaders

## Usage
In order to use this mod as a template:

1. Create a new repository from this template with `Use this template`
2. Clone the recently-created repo on your PC
3. Make the necessary changes to make it yours:
    - Update `build.gradle` in order to use your Maven group and mod ID
        - If you don't know which Maven group to use, and you are planning to host the mod's source code on GitHub, use `io.github.<Your_Username_Here>.<Mod_ID_Here>`
    - Update the `mods.groovy` file with your mod's metadata, such as the mod name, description, authors, etc...
    - Update the `src\main\groovy` sub-directory structure so it reflects your Maven group
   - Change the entrypoint class name from `ExampleMod` to your mod ID

## Licence
This template on the GroovyMC GitHub is licenced under the [MIT licence](LICENSE-TEMPLATE).

Mods created with this template are not automatically licenced under MIT and are not required to give any kind of
credit back to GroovyMC or the template authors.

By default, mods using this template are All Rights Reserved. You can change this by creating a `LICENSE` file in the
repo's root directory and updating the `mods.groovy` file to reflect the new licence.

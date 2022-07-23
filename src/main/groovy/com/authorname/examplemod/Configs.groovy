package com.authorname.examplemod

import ga.ozli.minecraftmods.groovylicious.transform.Config
import groovy.transform.CompileStatic
import groovy.transform.stc.POJO

@POJO
@CompileStatic
class Configs {
    @Config
    class Common {
        /**
         * A counter of how many times the mod has been run.
         */
        static short runCounter = 1
    }
}

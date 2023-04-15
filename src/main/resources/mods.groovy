ModsDotGroovy.make {
    modLoader = 'aplp'
    loaderVersion = '[1,)'

    license = 'All rights reserved'
    issueTrackerUrl = 'https://github.com/GroovyMC/GroovyMDK/issues'

    mod {
        modId = 'examplemod'
        displayName = 'Example Mod'
        description = 'An example mod based on the GroovyMDK template'
        version = '1.0.0'

        author = 'authorName'
        //authors = ['authorName', 'authorName2']

        displayUrl = 'https://github.com/GroovyMC/GroovyMDK'

        dependencies {
            forge = '>=40.2.0'
            minecraft = this.minecraftVersionRange
        }
    }
}

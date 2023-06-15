ModsDotGroovy.make {
    modLoader = 'gml'
    loaderVersion = '[3,)'

    license = 'All rights reserved'
    issueTrackerUrl = 'https://github.com/GroovyMC/GroovyMDK/issues'

    mod {
        modId = 'examplemod'
        displayName = 'Example Mod'
        description = 'An example Groovy mod made using the GroovyMDK template'
        version = '1.0.0'

        author = 'authorName'
        //authors = ['authorName', 'authorName2']

        displayUrl = 'https://github.com/GroovyMC/GroovyMDK'

        dependencies {
            forge = '>=45.1.0'
            minecraft = this.minecraftVersionRange
        }
    }
}

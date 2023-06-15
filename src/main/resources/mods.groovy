ModsDotGroovy.make {
    modLoader = 'gml'
    loaderVersion = '[4,)'

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
            forge = '>=47.0.1'
            minecraft = this.minecraftVersionRange // this is a special variable that will be replaced with '[1.20.1,1.21)'
        }
    }
}

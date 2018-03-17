job('NodeJS Docker DSL Demo') {
    scm {
        git('git@github.com:bigfishfastswimer/Udemy-docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('fishereatworld2018/nodejs-docker-fisher-17032018')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('fishereatworld2018')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}

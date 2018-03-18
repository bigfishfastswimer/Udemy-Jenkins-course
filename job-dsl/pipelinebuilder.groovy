pipelineJob ('Docker Pipeline dsl') {
  definition {
    cpsScm {
      scm {
<<<<<<< HEAD
        git {
=======
        git('https://github.com/bigfishfastswimer/Udemy-docker-demo', 'master') {
>>>>>>> parent of 1d82728... update credentials
          node / gitConfigName('DSL User')
          node / gitConfigEmail('fisherhuang1986@gmail.com')
        //  branch('master')
          remote {
            credentials('Jenkins-UdemyCourse-aws')
          }
        }
      }
      scriptPath('misc/Jenkinsfile.v3')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  logRotator {
    daysToKeep(2)
    numToKeep(4)
  }
}

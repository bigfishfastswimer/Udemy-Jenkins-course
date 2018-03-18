pipelineJob ('Docker Pipeline dsl') {
  definition {
    cpsScm {
      scm {
        git ('git@github.com:bigfishfastswimer/Udemy-docker-demo.git'){
          node / gitConfigName('DSL User')
          node / gitConfigEmail('fisherhuang1986@gmail.com')
        //  branch('master')
          remote {
            github('bigfishfastswimer/Udemy-docker-demo', 'ssh')
            credentials('Jenkins-UdemyCourse-aws')
          }
          branch('*/**')
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

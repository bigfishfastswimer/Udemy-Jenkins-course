pipelineJob ('Docker Pipeline dsl') {
  definition {
    cpsScm {
      scm {
        git ('git@github.com:bigfishfastswimer/Udemy-docker-demo.git'){ node -> //is hudson.plugin.git.Gitscm
            node / gitConfigName('DSL User')
            node / gitConfigEmail('fisherhuang1986@gmail.com')
          
          remote {
              //github('bigfishfastswimer/Udemy-docker-demo', 'ssh', 'github.com')
              credentials('Jenkins-UdemyCourse-aws')
          }
          branch('*/**')
        }
      }
      scriptPath('misc/Jenkinsfile.v3')
    }
  }
  triggers {
    githubPush()
  }
  logRotator {
    daysToKeep(2)
    numToKeep(4)
  }
}

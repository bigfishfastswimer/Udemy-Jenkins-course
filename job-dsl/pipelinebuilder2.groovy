pipelineJob ('Docker Pipeline dsl') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
              //github('bigfishfastswimer/Udemy-docker-demo', 'ssh', 'github.com')
              url("git@github.com:bigfishfastswimer/Udemy-docker-demo.git")
              credentials('Jenkins-UdemyCourse-aws')
          }
          node -> //is hudson.plugin.git.Gitscm
              node / gitConfigName('DSL User')
              node / gitConfigEmail('fisherhuang1986@gmail.com')
          branch("*/**")
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

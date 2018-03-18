pipelineJob ('Docker Pipeline dsl') {
  definition {
    cpsScm {
      scm {
        git('https://github.com/bigfishfastswimer/Udemy-Jenkins-course.git', 'master') {
          node / gitConfigName('DSL User')
          node / gitConfigEmail('fisherhuang1986@gmail.com')
        //  branch('master')
        }
      }
      scriptPath('misc/Jenkinsfile.v3')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  logRotator {
    daysToKeep('2')
    numToKeep('4')
  }
}

pipelinejob ('Docker Pipeline dsl') {
  definition {
    cpsScm {
      scm {
        git('https://https://github.com/bigfishfastswimer/Udemy-Jenkins-course.git') {
          node / gitConfigName('DSL User')
          node / gitConfigEmail('fisherhuang1986@gmail.com')
          branch('master')
        }
      }
      scriptPath('misc/Jenkins.v3')
    }
  }
  triggers {
    scm('H/5 * * * *')
  }
  logRotator {
    daysToKeep('2')
    numToKeep('4')
  }
  wrappers {
    nodejs('nodejs') // this is the name of the NodeJS installation in
                      // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
  }
}

pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Build') {
          steps {
            echo 'building microservice projects'
          }
        }

        stage('Test') {
          steps {
            echo 'Testing the app'
          }
        }

      }
    }

    stage('Deploy') {
      steps {
        echo 'deploying apps'
      }
    }

  }
}
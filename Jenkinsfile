pipeline {
  agent any
  stages {
    stage('Build') {
      parallel {
        stage('Start') {
          steps {
            echo 'building microservice projects'
          }
        }

        stage('Build eureka-server') {
          steps {
            sh '''cd eureka-server
mvn package'''
          }
        }

        stage('Build report-generator') {
          steps {
            sh '''cd report-generator
mvn package'''
          }
        }

        stage('Build spring-cloud-server') {
          steps {
            sh '''cd spring-cloud-server
mvn package'''
          }
        }

        stage('Build transactions-client') {
          steps {
            sh '''cd transactions-client
mvn package'''
          }
        }

        stage('Build zuul-api-gateway') {
          steps {
            sh '''cd zuul-api-gateway
mvn package'''
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
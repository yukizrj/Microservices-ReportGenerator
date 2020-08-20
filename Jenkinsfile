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
pwd'''
          }
        }

        stage('Build report-generator') {
          steps {
            sh '''cd report-generator
pwd'''
          }
        }

        stage('Build spring-cloud-server') {
          steps {
            sh '''cd spring-cloud-server
pwd'''
          }
        }

        stage('Build transactions-client') {
          steps {
            sh '''cd transactions-client
pwd'''
          }
        }

        stage('Build zuul-api-gateway') {
          steps {
            sh '''cd zuul-api-gateway
pwd'''
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
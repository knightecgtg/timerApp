// Jenkinsfile

pipeline {
  // Assign to docker slave(s) label, could also be 'any'
  agent {
    label 'docker'
  }

  stages {
    stage('Docker node test') {
      agent {
        docker {
          // Set both label and image
          label 'latest'
          image 'knightecab/timerapp:latest'
        }
      }
      steps {
        // Steps run in node:7-alpine docker container on docker slave
        sh 'node --version'
      }
    }
  }
}
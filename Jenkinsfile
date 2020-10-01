pipeline {
    environment {
        registry = "knightecab/timer_app_docker"
        registryCredential = 'dock_jen'
        dockerImage = ''
    }
    agent any
    stages {
        stage('Cloning our Git') {
            steps {
            git branch: 'develop',
            credentialsId: 'timerDevops',
            url: 'https://github.com/knightecgtg/timerApp.git'
            }
        }
        stage('Building our image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy our image') {
            steps {
                script {
                    docker.withRegistry( '', registryCredential ) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage('Deploy in container'){
        steps {
            sh "docker run --publish 8000:8080 --detach --name timercontainer $registry:$BUILD_NUMBER"
         }
        }
        stage('Cleaning up') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }
}
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
                git 'https://github.com/knightecgtg/timerApp.git'
            }
        }
        
    }
}
pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Source code is checked out from GitHub by Jenkins.'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }
    }

    post {
        success {
            echo 'Build Successful!'
        }

        failure {
            echo 'Build Failed!'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}
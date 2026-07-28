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
       stage('OWASP Dependency Check') {
    steps {
        dependencyCheck(
            odcInstallation: 'DependencyCheck',
            additionalArguments: '--format HTML --format XML'
        )
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
           dependencyCheckPublisher(
            pattern: '**/dependency-check-report.xml'
        )
        }
    }
}
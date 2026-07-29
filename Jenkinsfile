pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Source code checked out from GitHub.'
            }
        }

        stage('Build & Verify') {
            steps {
                bat 'mvn clean verify'
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
        stage('SonarQube Analysis') {
    steps {
        withSonarQubeEnv('SonarQube') {
            bat '''
                mvn sonar:sonar ^
                -Dsonar.projectKey=company-common ^
                -Dsonar.projectName=company-common
            '''
        }
    }
}
stage('Quality Gate') {
    steps {
        timeout(time: 5, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
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
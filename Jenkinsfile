pipeline {
    agent any

    environment {
        MAVEN_HOME = "C:\\Program Files\\Apache\\Maven"
        PATH = "${env.PATH};${env.MAVEN_HOME}\\bin"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master',
                url: 'https://github.com/flavienrandria81/EtecSite.git'
            }
        }

        stage('Verify Structure') {
            steps {
                bat 'dir'
            }
        }

        stage('Clean & Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'BUILD SUCCESS 🎉'
        }

        failure {
            echo 'BUILD FAILED ❌ check logs'
        }

        always {
            cleanWs()
        }
    }
}
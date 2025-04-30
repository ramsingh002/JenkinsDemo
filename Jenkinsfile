pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {
        stage("SCM Checkout") {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ramsingh002/JenkinsDemo.git']])
            }
        }

        stage("Build Process") {
            steps{
                script{
                    sh "mvn clean install"
                }
            }
        }
    }
}
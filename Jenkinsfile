pipeline {
    agent any

    tools {
        maven "maven"
    }

    stages {
        stage("SCM Checkout") {
            steps {
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ramsingh002/JenkinsDemo']])
            }
        }

        stage("Build Process") {
            steps{
                script{
                    bat "mvn clean install"
                }
            }
        }

        stage("Build Docker Image") {
            steps{
                script{
                    bat "docker build -t ramsingh002/spring-cicd:2.0 ."
                }
            }
        }

        stage("Deploy Image to Docker Hub") {
            steps{
                withCredentials([string(credentialsId: 'dockerpassword', variable: 'dockerpassword')]) {
                    bat "docker login -u ramsingh002 -p ${dockerpassword}"
                    bat "docker push ramsingh002/spring-cicd:2.0"
                }
            }
        }
    }

    post(){
        always{
            emailext body: '''<html>
                <body>
                    <p>Build Status : ${BUILD_STATUS}</p>
                    <p>Build Status : ${BUILD_NUMBER}</p>
                    <p>Check The: <a href<"${BUILD_URL}"/> Console Output</p>
               </body>
            </html>''', subject: 'Pipelinw and Build Stauts: ${BUILD_NUMBER}', to: 'rsalliswell@gmail.com'
        }
    }
}
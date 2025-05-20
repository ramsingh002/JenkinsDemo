pipeline {
    agent any

    tools {
        maven "maven"
    }

    environment{
        APP_NAME = "spring-docker-cicd"
        RELEASE_NUMBER = "1.0.0"
        DOCKER_USERNAME = "ramsingh002"
        IMAGE_NAME = "${DOCKER_USERNAME}"+"/"+"${APP_NAME}"
        IMAGE_TAG = "${RELEASE_NUMBER}-${BUILD_NUMBER}"
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
                    bat "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                }
            }
        }

        stage("Deploy Image to Docker Hub") {
            steps{
                withCredentials([string(credentialsId: 'dockerpassword', variable: 'dockerpassword')]) {
                    bat "docker login -u ${DOCKER_USERNAME} -p ${dockerpassword}"
                    bat "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
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
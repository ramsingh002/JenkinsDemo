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

        stage("Deploy to Container") {
            steps{
                deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomcatpwd', path: '', url: 'http://localhost:9090/')], contextPath: 'JenkinsCICD', war: '**/*.war'
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
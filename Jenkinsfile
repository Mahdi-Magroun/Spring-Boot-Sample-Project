pipeline {
    agent any

    stages {
        stage('build') {
            steps {
              sh "mvn clean install"
            }
        }
        stage('test') {
            steps {
                echo 'Hello World war 3.01 ' 
            }
    }
         stage('deploy') {
            steps {
                echo 'Hello World war 3.01 ' 
            }
    }
        
}
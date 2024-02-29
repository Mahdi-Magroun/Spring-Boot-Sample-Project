pipeline {
    agent any

    stages {
        stage('build') {
            steps {
              sh "./mvnw clean install"
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

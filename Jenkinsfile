
pipeline {
    agent any

    stages {
        stage('build') {
            steps {
            echo "building ...."
            sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('test') {
            steps {
                echo 'testing .... ' 
            }
    }
         stage('deploy') {
            steps {
                echo 'deploying ....' 
                sh 'docker build -t myjava_app .'
            }
    }
    }
}

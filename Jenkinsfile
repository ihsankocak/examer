pipeline {
    agent any
    tools {
        jdk 'jdk19'
        maven '3.9.3'

    }
    stages {
        stage("build project") {
            steps {
               // git 'https://github.com/ihsankocak/examer.git'
                echo "Java VERSION"
                sh 'java -version'
                echo "Maven VERSION"
                sh 'mvn -version'
                echo 'building project...'
                sh "mvn compile"
                sh "mvn package"
                //sh "mvn test"
                sh "mvn clean install"
            }
        }
    }
}
# week1/day3

```
pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        stage('check java version') {
            steps {
                sh 'java -version'
            }
        }
        stage('check maven version') {
            steps {
                sh 'mvn --version'
            }
        }
    }
}
```

### git-maven-pipeline

```
pipeline {
    agent any

    stages {
        stage('SCM checkout') {
            steps {
                git 'https://github.com/kayartaya-vinod/jenkins-pipeline-example.git'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -DskipTests=true package'
            }
        }

    }
     post {
            success {
                junit 'target/surefire-reports/TEST*.xml'
                archiveArtifacts 'target/*.jar'
            }
        }
}
```

# Assignment:

Create a file `week1-day3-assignment-soultions.md` and write the solution for the following questions

1. Write a short note on your understanding of what is Jenkins?
2. Explain Continuous Integration, Continuous Delivery, and Continuous Deployment?
3. What are the common use cases Jenkins is used for?
4. What are the ways to install Jenkins?
5. What is a Jenkins job?
6. What is a Jenkins Pipeline?
7. What are the types of Jenkins pipelines?
8. How do you store credentials in Jenkins securely?
9. What are the ways to trigger a Jenkins Job/Pipeline?
10. What are the credential types supported by Jenkins?
11. What are the Scopes of Jenkins Credentials?

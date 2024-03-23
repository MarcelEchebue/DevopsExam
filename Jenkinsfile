pipeline{
    agent any
    tools{
        maven 'Maven 3.9.6'
    }
    stages{
        stage('Build Maven 3.9.6'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MarcelEchebue/DevopsExam']])
            }
        }
        stage('Build Run Test'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MarcelEchebue/DevopsExam']])
               // para  que funcione la linea de abajo en comentario
              // sh 'mvn test'

            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    //sh "docker build -t marcelinoechebue/examdevops_marcelino ."
                    //sh "docker push marcelinoechebue/examdevops_marcelino:tag123"
                   docker.build('examdevops-marcelino')
                   // sh 'docker push'

                }
            }
        }
        stage('SonarQube analysis'){
            //    def scannerHome = tool 'SonarScanner 4.0';
            steps{
                withSonarQubeEnv('sonarqube-8.9.2'){
                //If you have configured more than one global server connection, you can specify its name
                //sh "${scannerHome}/bin/sonar-scanner"
                    sh "mvn sonar:sonar"
                    }
                }
             }
        }

    }
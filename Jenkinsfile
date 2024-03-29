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
                 //para  que funcione la linea de abajo en comentario
                //sh 'mvn test'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    //sh "docker build -t marcelinoechebue/examdevops_marcelino ."
                    //sh "docker push marcelinoechebue/examdevops_marcelino:tag123"
                    docker.build('examdevops_marcelino')
                   // sh
                   //para que se cree la imagen es lo de abajo
                  // docker.push('examdevops_marcelino')

                }
            }
        }
        stage('SonarQube analysis') {
            steps{
              withSonarQubeEnv('sonarqube') {
                // If you have configured more than one global server connection, you can specify its name
                  //sh "${scannerHome}/bin/sonar-scanner"
                    sh 'mvn sonar:sonar'
                    }
                }
            }

    }

}
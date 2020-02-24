pipeline
{
    environment
    {
        PATH = "$PATH:../docker"
    }
    agent any
    tools
    {
        maven "Maven"
    }
    stages
    {
//         stage('Initialize')
//         {
//             steps
//             {
//                 def dockerHome = tool 'Docker'
//                 env.PATH = "${dockerHome}/bin:${env.PATH}"
//             }
//         }
        stage ("Docker Compose")
        {
            steps
            {
                sh "docker-compose -f ./dockerapp-compose.yml up"
            }
        }
        stage('Clean')
        {
            steps
            {
                sh 'mvn clean'
            }
        }
        stage('Test')
        {
            steps
            {
                sh 'mvn test'
            }
            post
            {
                always
                {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
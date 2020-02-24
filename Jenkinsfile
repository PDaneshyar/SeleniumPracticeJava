pipeline
{
    agent any
    tools
    {
        maven "Maven"
        docker "Docker"
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
                sh "docker-compose up"
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
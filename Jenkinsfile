pipeline
{
    agent any
    tools
    {
        maven "Maven"
    }
    environment
    {
        PATH = "$PATH:/var/jenkins_home"
    }
    stages
    {
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
pipeline
{
    agent any
    tools
    {
        maven "Maven"
    }
    stages
    {
        stage ("Docker Compose")
        {
            steps
            {
                sh "../documents/docker-app/TestFramework/docker-compose build"
                sh "../documents/docker-app/TestFramework/docker-compose up"
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
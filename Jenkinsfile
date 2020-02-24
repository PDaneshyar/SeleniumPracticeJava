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
                sh "docker-compose.sh "
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
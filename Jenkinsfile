pipeline
{
    agent any
    tools
    {
        maven "Maven"
    }
    environment
    {
        PATH = "$PATH:/usr/local/bin/"
    }
    stages
    {
        stage ("Docker Compose")
        {
            steps
            {
                withenv(PATH)
                {
                    sh "docker-compose -f ./dockerapp-compose.yml up"
                }
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
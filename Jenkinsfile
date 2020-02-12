pipeline
{
    agent any
    tools
    {
        maven "Maven"
    }
    stages
    {
        stage('build')
        {
            steps
            {
                sh 'mvn -B -DSkipTests clean package'
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
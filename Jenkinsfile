pipeline
{
    agent any
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
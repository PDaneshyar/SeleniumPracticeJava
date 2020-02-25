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
                //sh "chmod +x /var/jenkins_home/docker-compose"
                sh "docker-compose dockerapp-compose.yml up"
            }
//             steps
//             {
//                 $class: 'DockerComposeBuilder', dockerComposeFile: 'dockerapp-compose.yml', option: [$class: 'StartAllServices'], useCustomDockerComposeFile: true
//             }
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
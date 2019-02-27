node {

        withMaven(maven:'maven') {
          stage('Checkout') {
            git url: 'https://github.com/Nightmayr/FootballManager-MongoClientService.git', branch: 'development'
        }
 
        stage('Build') {
            sh 'mvn package -Dmaven.test.skip=true spring-boot:repackage'
        }
 
        stage('Image') {
            docker.build "mongoclient"
        }
 
        stage ('Run') {
            docker.image("mongoclient").run('-p 8085:8085 -h mongoclient --network football --name mongoclient')
        }
 
        stage ('Final') {
            build job: 'consumer-service-pipeline', wait: false
        }
    }
 
}

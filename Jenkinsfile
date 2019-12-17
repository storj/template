pipeline {
    agent {
        dockerfile {
            filename 'ci/Dockerfile'
            args '-u root:root --cap-add SYS_PTRACE -v "/tmp/gomod":/go/pkg/mod'
            label 'main'
        }
    }
    options {
          timeout(time: 26, unit: 'MINUTES')
    }
    environment {
        NPM_CONFIG_CACHE = '/tmp/npm/cache'
    }
    stages {
        stage('Build') {
            steps {
                checkout scm

                // ensure that services can start
                sh 'service postgresql start'

                sh 'cockroach start --insecure --store=\'/tmp/crdb\' --listen-addr=localhost:26257 --http-addr=localhost:8080 --join=localhost:26257 --background'
                sh 'cockroach init --insecure --host=localhost:26257'
            }
        }

        stage('Lint') {
            load "ci/Jenkins.shared"
        }
    }

    post {
        always {
            sh "chmod -R 777 ." // ensure Jenkins agent can delete the working directory
            deleteDir()
        }
    }
}
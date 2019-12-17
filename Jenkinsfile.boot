node {
    checkout scm

    checkout([
        $class: 'GitSCM',
        branches: [[name: '*/master']],
        doGenerateSubmoduleConfigurations: false,
        extensions: [[$class: 'RelativeTargetDirectory',
        relativeTargetDir: 'ci']],
        submoduleCfg: [],
        userRemoteConfigs: [[url: 'https://github.com/storj/ci.git']]])

    load 'Jenkinsfile'
}
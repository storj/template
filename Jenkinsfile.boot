node {
    checkout([
        $class: 'GitSCM',
        branches: [[name: '*/master']],
        doGenerateSubmoduleConfigurations: false,
        extensions: [[$class: 'RelativeTargetDirectory',
        relativeTargetDir: 'ci']],
        submoduleCfg: [],
        userRemoteConfigs: [[url: 'https://github.com/storj/ci.git']]])
    
    // run main Jenkinsfile
    load 'Jenkinsfile'
}
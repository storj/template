node {
    checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'ci']], submoduleCfg: [], userRemoteConfigs: [[url: 'storj/ci.git']]])
    // run second script
    load 'ci/Jenkinsfile'
}
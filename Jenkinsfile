// Jenkinsfile
@Library('my-shared-library') _

node {
    cleanWs()
    checkout scm

    stage('Load Config') {
        if (fileExists('pipeline_config.groovy')) {
            // This loads the script and extracts the returned map directly
            def configMap = load 'pipeline_config.groovy'
            
            echo "Loaded Configuration successfully for Environment: ${configMap.ENVIRONMENT}"

            // Hand the map over to your shared library function
            kafkaDeploy(configMap)
        } else {
            error "Configuration file 'pipeline_config.groovy' not found!"
        }
    }
}

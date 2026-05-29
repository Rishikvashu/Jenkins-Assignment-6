// Jenkinsfile
@Library('my-shared-library') _

node {
    // Step 1: Clean workspace and checkout this repo's files
    cleanWs()
    checkout scm

    // Step 2: Load variables from the configuration file
    stage('Load Config') {
        if (fileExists('pipeline_config.groovy')) {
            def configScript = load 'pipeline_config.groovy'
            
            // Map configuration variables dynamically
            def configMap = [
                SLACK_CHANNEL_NAME : configScript.SLACK_CHANNEL_NAME,
                ENVIRONMENT        : configScript.ENVIRONMENT,
                CODE_BASE_PATH     : configScript.CODE_BASE_PATH,
                ACTION_MESSAGE     : configScript.ACTION_MESSAGE,
                KEEP_APPROVAL_STAGE: configScript.KEEP_APPROVAL_STAGE
            ]

            // Step 3: Call the Shared Library function
            kafkaDeploy(configMap)
        } else {
            error "Configuration file 'pipeline_config.groovy' not found!"
        }
    }
}

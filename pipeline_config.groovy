// pipeline_config.groovy

// Define a map containing all settings
def config = [
    SLACK_CHANNEL_NAME : '#social',
    ENVIRONMENT        : 'prod',
    CODE_BASE_PATH     : 'env/prod',
    ACTION_MESSAGE     : 'Deploying Kafka Clusters to Production Environment',
    KEEP_APPROVAL_STAGE: true
]

// Explicitly return the map so the loading script receives it
return config

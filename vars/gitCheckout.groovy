def call(String repoUrl, String branch, String github-token) {
    echo "Checking out code from ${repoUrl}..."
    checkout([
        $class: 'GitSCM',
        branches: [[name: branch]],
        userRemoteConfigs: [[credentialsId: github-token, url: repoUrl]]
    ])
}
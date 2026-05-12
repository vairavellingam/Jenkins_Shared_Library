def call(String imageName, String credId) {
    echo "Building Docker image ${imageName}..."
    def dockerImage = docker.build("${imageName}:latest")
    
    echo "Pushing Docker image to DockerHub..."
    docker.withRegistry('https://registry.hub.docker.com', credId) {
        dockerImage.push('latest')
    }
}
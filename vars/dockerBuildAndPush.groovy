def call(String imageName, String dockerhub-token) {
    echo "Building Docker image ${imageName}..."
    def dockerImage = docker.build("${imageName}:latest")
    
    echo "Pushing Docker image to DockerHub..."
    docker.withRegistry('https://registry.hub.docker.com', dockerhub-token) {
        dockerImage.push('latest')
    }
}
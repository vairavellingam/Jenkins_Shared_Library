# Jenkins Shared Library

A reusable **Jenkins Shared Library** built to simplify and standardize CI/CD pipeline automation across multiple projects. This library provides modular Groovy scripts for common DevOps tasks such as  Docker image build & push, kubectl installation, and Kubernetes deployment.

By centralizing reusable pipeline logic, this project improves maintainability, scalability, and consistency in Jenkins-based automation workflows.

---

## Features

- Reusable Jenkins Shared Library architecture
- Modular Groovy pipeline scripts
- Git repository checkout automation
- Docker image build and registry push
- Kubectl installation in Jenkins agent
- Kubernetes deployment automation
- Reduced code duplication across Jenkins pipelines
- Scalable CI/CD workflow integration

---

## Repository Structure

```bash
JENKINS-SHARED-LIBRARY/
│
├── vars/
│   ├── gitCheckout.groovy
│   ├── dockerBuildAndPush.groovy
│   ├── installKubectl.groovy
│   └── k8sDeploy.groovy
│
└── README.md
```

---

## Module Description

### 1. `gitCheckout.groovy`
Handles Git repository checkout from a specified branch.

**Purpose:**
- Clone source code from Git repository
- Support reusable SCM checkout logic
- Simplify Jenkins pipeline setup

---

### 2. `dockerBuildAndPush.groovy`
Automates Docker image creation and pushes the image to a container registry.

**Purpose:**
- Build Docker images
- Tag images
- Push images to Docker Hub / private registry
- Standardize containerization workflow

---

### 3. `installKubectl.groovy`
Installs and configures `kubectl` on the Jenkins agent.

**Purpose:**
- Install kubectl dynamically
- Ensure Kubernetes CLI availability
- Support deployment automation

---

### 4. `k8sDeploy.groovy`
Applies Kubernetes manifests for application deployment.

**Purpose:**
- Deploy `deployment.yaml`
- Deploy `service.yaml`
- Manage Kubernetes rollout process
- Simplify cluster deployment execution

---

## Example Jenkins Pipeline Usage

```groovy
@Library('jenkins-shared-library') _

pipeline {
    agent any

    stages {

        stage('Checkout Source') {
            steps {
                script {
                    gitCheckout('main')
                }
            }
        }

        stage('Build & Push Docker Image') {
            steps {
                script {
                    dockerBuildAndPush()
                }
            }
        }

        stage('Install Kubectl') {
            steps {
                script {
                    installKubectl()
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                script {
                    k8sDeploy('kubeconfig-credential-id')
                }
            }
        }
    }
}
```

---

## CI/CD Workflow

This shared library supports the following automation flow:

1. Checkout application source code  
2. Build Docker image  
3. Push image to container registry  
4. Install kubectl on Jenkins agent  
5. Connect to Kubernetes cluster  
6. Deploy manifests (`deployment.yaml`, `service.yaml`)  
7. Release application

---

## Tech Stack

- Jenkins Shared Library
- Groovy
- Jenkins Pipeline
- Git
- Docker
- Docker Registry
- Kubernetes
- Kubectl
- CI/CD
- DevOps Automation

---

## Benefits of This Shared Library

- Centralized reusable pipeline logic
- Cleaner Jenkinsfiles
- Reduced repetitive scripting
- Faster CI/CD implementation
- Easier maintenance across projects
- Better deployment consistency
- Improved scalability for enterprise workflows

---

##

Developed to demonstrate reusable Jenkins Shared Library design for scalable CI/CD automation using Docker and Kubernetes.

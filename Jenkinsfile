pipeline {
    agent any

    tools {
        maven 'MAVEN_HOME'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/khalid0210/OrangeHRM_Framework.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Reports') {
            steps {
                publishHTML(target: [
                    reportDir: 'test-output/ExtentReport',
                    reportFiles: 'extent-report.html',
                    reportName: 'Extent Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'test-output/ExtentReport/extent-report.html', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }

        success {
            emailext (
                to: 'khalithsheik@gmail.com',
                subject: "✅ Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    <html>
                    <body>
                    <p>Hello Team,</p>
                    <p>The latest Jenkins build has completed successfully.</p>
                    <p><b>Project:</b> ${env.JOB_NAME}</p>
                    <p><b>Build Number:</b> #${env.BUILD_NUMBER}</p>
                    <p><b>Status:</b> <span style="color: green;"><b>SUCCESS</b></span></p>
                    <p><b>Build URL:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                    <p><b>Extent Report:</b> <a href="${env.BUILD_URL}Extent_Report/">Click here</a></p>
                    <br>
                    <p>Regards,<br><b>Automation Team</b></p>
                    </body>
                    </html>
                """,
                mimeType: 'text/html',
                attachLog: true
            )
        }

        failure {
            emailext (
                to: 'khalithsheik@gmail.com',
                subject: "❌ Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                    <html>
                    <body>
                    <p>Hello Team,</p>
                    <p>The Jenkins build has <span style="color: red;"><b>FAILED</b></span>.</p>
                    <p><b>Project:</b> ${env.JOB_NAME}</p>
                    <p><b>Build Number:</b> #${env.BUILD_NUMBER}</p>
                    <p><b>Build URL:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                    <br>
                    <p>Please check the logs and report for more details.</p>
                    </body>
                    </html>
                """,
                mimeType: 'text/html',
                attachLog: true
            )
        }
    }
}

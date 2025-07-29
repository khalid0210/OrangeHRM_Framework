pipeline {
    agent any

    tools {
        maven 'C:\Program Files\Maven\apache-maven-3.9.9'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/khalid0210/OrangeHRM_Framework.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
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
                    reportDir: 'src/test/resources/ExtentReport',
                    reportFiles: 'extent-report.html',
                    reportName: 'HTML Extent Report'
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/src/test/resources/ExtentReport/*.html', fingerprint: true
            junit 'target/surefire-reports/*.xml'
        }

        success {
            emailext (
                to: 'khalithsheik@gmail.com',
                subject: "Build Success: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: '''<html>
<body>
<p>Hello Team,</p>
<p>The latest Jenkins build has completed.</p>
<p><b>Project Name:</b> ${env.JOB_NAME}</p>
<p><b>Build Number:</b> #${env.BUILD_NUMBER}</p>
<p><b>Build Status:</b> <span style="color: green;"><b>SUCCESS</b></span></p>
<p><b>Build URL:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
<p><b>Last Commit:</b> ${env.GIT_COMMIT}</p>
<p><b>Branch:</b> ${env.GIT_BRANCH}</p>
<p><b>Build log is attached.</b></p>
<p><b>Extent Report (if available):</b> <a href="http://localhost:8080/job/OrangeHRM_Test_Suite/HTML_20Extent_20Report/">Click here</a></p>
<p>Best regards,</p>
<p><b>Automation Team</b></p>
</body>
</html>''',
                mimeType: 'text/html',
                attachLog: true
            )
        }
    }
}

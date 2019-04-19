pipeline {
	agent any 
		stages {
			stage('One') {
				steps {
					echo 'Starting pipeline. This is step of stage One'
				}
			}
			stage('Two') {
				steps {
					input('Do you want to continue?')
				}
			}
			stage('Three') {
				steps {
					mvn clean test
				}
			}
			stage('Four') {
				steps {
					echo 'Completed'
				}
			}
		}
}
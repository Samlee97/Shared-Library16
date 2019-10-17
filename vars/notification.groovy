def call(String buildResult) {
   
if ( buildResult == "SUCCESS" ) {	   
     slackSend (color: '#00FF00', message: "SUCCESSFUL: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")	     
     emailext body: 'Build Success', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test', to: 'vipuldevops1994@gmail.com'
}	
   
if ( buildResult == "FAILURE" ) { 	     
   slackSend (color: '#FF0000', message: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")	   
   emailext body: 'Build Failure', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test', to: 'vipuldevops1994@gmail.com'	 
}
}

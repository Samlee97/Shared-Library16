import groovy.json.JsonSlurper 
@NonCPS

sonar(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
withSonarQubeEnv('Sonar') {
                curl -u admin:admin -X POST 'http://ec2-18-224-155-110.us-east-2.compute.amazonaws.com:9000/api/projects/create?key=lee&name=sam
                }
                }
                
                
def call(){
def request = libraryResource 'data.json'
 sonar(request)
}

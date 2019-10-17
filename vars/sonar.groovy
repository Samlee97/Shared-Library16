import groovy.json.JsonSlurper 
@NonCPS

sonar(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
withSonarQubeEnv('Sonar') {
                sh 'mvn sonar:sonar -Dproject.settings=./sonar.properties'
                }
                }
                
                
def call(){
def request = libraryResource 'data.json'
 sonar(request)
}

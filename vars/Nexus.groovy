import groovy.json.JsonSlurper 

@NonCPS
Nexus(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
                   
def artf='"'+resultJson.Nexus.artifactId+'""'

                      }
def call(){
def request = libraryResource 'data.json'
 Nexus(request)
}

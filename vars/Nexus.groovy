import groovy.json.JsonSlurper 

@NonCPS
Nexus(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
  
def repo='"'+resultJson.Nexus.repository_name+'"'                   
def artf='"'+resultJson.Nexus.artifactId+'"'
  print(artf)

                      }
def call(){
def request = libraryResource 'data.json'
 Nexus(request)
}

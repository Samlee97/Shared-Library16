import groovy.json.JsonSlurper 

@NonCPS
createProject(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projectName = '"'+resultJson.name+'"'
def length = 3
def projLength = resultJson.name.size()
 if(projLength>=3){
  key=resultJson.name.substring(0, Math.min(projLength, length)).toUpperCase();
 }
 else {
   def appendStr = "";
   int currentLength=length;
   int len = currentLength%projLength;
   int repeat = currentLength/projLength;
   for (int i=0;i<repeat;i++) {
    appendStr = appendStr + resultJson.name;
   }
   appendStr=appendStr+resultJson.name.substring(0, Math.min(projectName.length(), len));
   key=appendStr.toUpperCase();
 }
  def projKey = '"'+key+'"'
  httpRequest authentication: 'bitbucket_anu', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """{
    "key": ${projKey},
    "name": ${projectName}
}""", responseHandle: 'NONE', url: 'http://18.224.68.30:7990/rest/api/1.0/projects'
}

 def call(){
 def request = libraryResource 'data.json'
 createProject(request)
}

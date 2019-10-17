import hudson.model.*
import groovy.json.JsonSlurper 

// get current thread / Executor
def thr = Thread.currentThread()
// get current build
def build = thr?.executable
 
 
// get parameters
def parameters = build?.actions.find{BB_URL}?.parameters
parameters.each {
   println "parameter ${BB_URL.name}:"
   println BB_URL.dump()
   println "-" * 80
}


@NonCPS
createProject(String data, String URL){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projectName = '"'+resultJson.name+'"'
def projUrl= resultJson.url
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
}""", responseHandle: 'NONE', url: "http://" + "${URL}" + "/rest/api/1.0/projects/"
}

 def call(String BITBUCKETURL){
 def request = libraryResource 'data.json'
 createProject(request,BITBUCKETURL)
 
 //println $BITBUCKETURL
  echo "hiiiiiiiiiiiiiiii, ${BITBUCKETURL}"
}



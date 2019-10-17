import groovy.json.JsonSlurper 

@NonCPS
createDevBranch(String data, String URL){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def branchName = '"'+resultJson.branch1+'"'
def projUrl = '"'+resultJson.url+'"'
  
  httpRequest authentication: 'bitbucket_anu', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: """
{
    "name": ${branchName},
    "startPoint": "refs/heads/master"
}""", responseHandle: 'NONE', url: "http://" + "${URL}" + "/rest/api/1.0/projects/DEM/repos/web_1/branches"
}


def call(String BITBUCKETURL){
 def request = libraryResource 'data.json'
 createDevBranch(request,BITBUCKETURL)
}



/*def call(String text){
httpRequest authentication: 'bitbucket_anu', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: '''{
    "name": "DEV",
    "startPoint": "refs/heads/master"
}''', responseHandle: 'NONE', url: 'http://18.224.68.30:7990/rest/api/1.0/projects/DEM/repos/web_1/branches'
}*/

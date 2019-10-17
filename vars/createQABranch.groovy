def call(){
httpRequest authentication: 'bitbucket_anu', contentType: 'APPLICATION_JSON', customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json']], httpMode: 'POST', requestBody: '''{
    "name": "QA",
    "startPoint": "refs/heads/master"
}''', responseHandle: 'NONE', url: 'http://18.224.68.30:7990/rest/api/1.0/projects/TEST_12/repos/test_123/branches'

}

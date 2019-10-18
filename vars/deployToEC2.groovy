import groovy.json.JsonSlurper
@NonCPS

def playbook(String inventory, String rolePath) {
    echo "Execute Ansible role..."
    def copyArtifact = "cp /var/lib/jenkins/workspace/JenkinsSharedLibrary/target/*.war /var/lib/jenkins/workspace/JenkinsSharedLibrary/ansiblerole/roles/DeployFromNexus/files"
    def shellCommand = "ansible-playbook -i  ${inventory} ${rolePath}"
    echo "Command is: ${shellCommand}"
    sh(shellCommand)
}
def gitClone() {
   echo "Executing Git Clone to download ansible role"
   
   def removeAnsibleRole = " rm -rf ansiblerole"
   sh(removeAnsibleRole)
   
   def request = libraryResource 'data.json'
   def jsonSlurper = new JsonSlurper() 
   def resultJson = jsonSlurper.parseText(request)
   def url = ansible.url[0]
   println('url')
 
   def shellCommand = "git clone ${url}"
   echo "Command is: ${shellCommand}"
   sh(shellCommand)
   def ppwd = "pwd"
   sh(ppwd)

}

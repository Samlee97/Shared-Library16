def playbook(String inventory, String rolePath) {
    echo "Execute Ansible role..."
    def copyArtifact = "cp /var/lib/jenkins/workspace/JenkinsSharedLibrary/target/*.war /var/lib/jenkins/workspace/JenkinsSharedLibrary/ansiblerole/roles/DeployFromNexus/files"
    def shellCommand = "ansible-playbook -i  ${inventory} ${rolePath}"
    echo "Command is: ${shellCommand}"
    sh(shellCommand)
}
def gitClone(String data) {
   echo "Executing Git Clone to download Artifact from Nexus to EC2 ansible role"

   def removeAnsibleRole = " rm -rf ansiblerole"
   sh(removeAnsibleRole)
    
   def jsonSlurper = new JsonSlurper() 
   def resultJson = jsonSlurper.parseText(data)
   url = ansible.url[0]
    println('url')
 
   def shellCommand = "git clone ${url}"
   echo "Command is: ${shellCommand}"
   sh(shellCommand)
   def ppwd = "pwd"
   sh(ppwd)

}

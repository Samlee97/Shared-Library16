def playbook(String inventory, String rolePath) {
    echo "Execute Ansible role..."
    
    def shellCommand = "ansible-playbook -i  ${inventory} ${rolePath}"
    echo "Command is: ${shellCommand}"
    sh(shellCommand)
}
def gitClone(String url) {
   echo "Executing Git Clone to download Artifact from Nexus to EC2 ansible role"

   def removeAnsibleRole = " rm -rf jenkinsinstallansiblerole"
   sh(removeAnsibleRole)
 
   def shellCommand = "git clone ${url}"
   echo "Command is: ${shellCommand}"
   sh(shellCommand)

}

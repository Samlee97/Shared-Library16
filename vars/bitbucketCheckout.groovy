def call(){
    def checkout = "git credentialsId: 'bitbucket_Url', url: 'http://rig@18.224.68.30:7990/scm/dem/app.git'"
    sh(checkout)
}

def call(){
    def checkout = "git clone http:///rig:${rig_password}@18.224.68.30:7990/scm/dem/app.git"
    //git clone http://rig:${rig_password}@${BB_URL}/scm/DEM/app.git
    sh(checkout)
}
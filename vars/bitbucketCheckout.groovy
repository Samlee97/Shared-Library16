def call(){
    def checkout = "rm -rf ./* && git clone http:///rig:${rig_password}@18.224.68.30:7990/scm/dem/app.git && cd app "
    //git clone http://rig:${rig_password}@${BB_URL}/scm/DEM/app.git
    sh(checkout)
}

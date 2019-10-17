def codeCoverage(String url) {

    def removeJavaProject="rm -rf messagebuilderjavaproject"
    sh(removeJavaProject)

    def shellCommand="git clone ${url}"
    echo"Command is: ${shellCommand}"
    sh(shellCommand)
    
}

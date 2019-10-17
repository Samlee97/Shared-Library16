/*** 
  "name" : "Bulk Delete Builds",
  "comment" : "For a given job and a given range of possible build numbers, delete those builds.",
  "parameters" : [ 'jobName', 'buildRange' ],
  "authors" : [
    { name : "Vipul" }
  ]
} **/




import jenkins.model.*;
import hudson.model.Fingerprint.RangeSet;
import jenkins.model.*
import hudson.model.*
import com.cloudbees.hudson.plugins.folder.*
import jenkins.branch.*
import org.jenkinsci.plugins.workflow.job.*
import org.jenkinsci.plugins.workflow.multibranch.*
  
def call() {
  
//************************************************************************************************ Case 1
  // give name of the job with the range of builds you want to delete .
/***
def jobName = "Deploy"
// The range of build numbers to delete.
def buildRange = "100-107"
def j = jenkins.model.Jenkins.instance.getItem(jobName);
def r = RangeSet.fromString(buildRange, true);
j.getBuilds(r).each { it.delete() }
**/
//************************************************************************************************
  
  
//************************************************************************************************ Case 2
//this will check for all builds and directly delete all builds below the max number mentioned
/**
def jobName = "N_D_P_P"
def maxNumber = 20
Jenkins.instance.getItemByFullName(jobName).builds.findAll {
  it.number <= maxNumber
}.each {
  it.delete()
} 
**/
//************************************************************************************************
  

//************************************************************************************************ Case 3
// this housekeeping groovy script is to delete all failed build till some maximum build number.
def jobName = "shared_lib_vipul"
def maxNumber = 200
Jenkins.instance.getItemByFullName(jobName).builds.findAll { it.result == Result.FAILURE && it.number <= maxNumber}.each { it.delete() }
}

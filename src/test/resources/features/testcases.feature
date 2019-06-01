@firstlaunch 
@alternatelogon 
Feature: test the scenarios 

Background:
Users prerequisit to launch the app and navigate to the Alternate logon screen 
	Given The user launches the app
	When The user confirms the user is on alternate logon screen 
	
@firstenroll @firstlogon 
Scenario Outline: Test Enroll and navigate to Basic Info Screen 
	When The user taps on enroll button 
	Then The user is displayed with "<screen>" screen 
	Examples: 	
				|screen    |	
				|basic info|
				|BAU Logon |

				

#Scenario Outline: Test Log on and navigate to BAU Logon Screen 
#	When The user taps on Log on button 
#	Then The user is displayed with BAU Logon Screen 
#	And verify that the element is present "<element>"	
#	Examples: 
#				|element    	|			
#				|email			|
#				|password		|	
#				|login button	|
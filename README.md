
# FaceAuthenticationHospital


Created a patient registration App that aims to simplify the patient registration process and enhance security by utilizing facial recognition technology.
This app allows patients to securely upload their personal information and scanned photo fromt heir homes,eliminating the need for in-person registration at the hospital.
Upon the patient's arrival at the hospital, the facial recognition technology will quickly and accurately verify their identity
against the registration information already stored in the app
database. 
The use of facial recognition technology will enhance security measures by ensuring that only the registered patient is present at the hospital, and a token can be issued for queuing outside the relevant room. 

This solution should provide a convenient and secure alternative to traditional registration methods, improving the patient experience and enabling healthcare providers to deliver care more efficiently.

# Open in android studio

Clone the repository using git clone https://github.com/:Savinwc/FaceAuthenticationHospital.git  OR Download ZIP of this project (under the 'Code' button on this page) and unzip to a folder.

In android studio, go to File -> Import Project then choose this project folder and then click Next -> Finish.

# Implementation

The following is how some of the most important parts of the app was implemented.

* Sign-Up/Login using email address and password using firebase authentication as the backend. Unique id generated for each user account by FirebaseAuth is used    to  save user info (such as account details, and messages sent) in Firebase Realtime Database. (user's node is set as unique id).Face Authentication used by Google ML Kit
 Face  data is stored in binary format in MS SQL Server.
* 
